package com.flui.db.Database;
public class GraphDatabase {

    public String execute(String command_str) {
        String[] command = command_str.split(" ");
        switch(command[0]){
            case "INSERT":
                return "";
            case "REMOVE":
                return "";
            case "FIND":
                return "";
            case "UPDATE":
                return "";
            default:
                return "ERROR: Unrecognized Command: "+command[0];
        }
    }
    
}
