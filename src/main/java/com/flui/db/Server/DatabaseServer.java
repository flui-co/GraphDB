package com.flui.db.Server;
import java.io.IOException;
import java.net.ServerSocket;

import com.flui.db.Database.GraphDatabase;

public class DatabaseServer {
    
    private ServerSocket serverSocket;
    private GraphDatabase db;

    public DatabaseServer(GraphDatabase gdb){
        db = gdb;
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true)
            new DBClientHandler(serverSocket.accept(),db).start();
    }
    public void stop() throws IOException{
        serverSocket.close();
    }

}
