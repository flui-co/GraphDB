package com.flui.db.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.flui.db.Database.GraphDatabase;

public class DBClientHandler extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GraphDatabase db;

    public DBClientHandler(Socket socket, GraphDatabase gdb) {
        this.clientSocket = socket;
        this.db = gdb;
    }

    public void run() {
        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
                );
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(inputLine.equals("STOP"))break;
                out.println(
                    db.execute(inputLine)
                );
            }

            in.close();
            out.close();
            clientSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
