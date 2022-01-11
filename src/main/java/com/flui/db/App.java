package com.flui.db;

import com.flui.db.Server.DatabaseServer;

import java.io.IOException;

import com.flui.db.Database.GraphDatabase;

public class App{

    public static void main(String[] args){
        System.out.println("starting local server");
        GraphDatabase db = new GraphDatabase();
        int port = 5425;
        DatabaseServer dbs = new DatabaseServer(db);
        try {
            dbs.start(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}