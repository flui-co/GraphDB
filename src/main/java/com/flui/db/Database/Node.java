package com.flui.db.Database;

import java.util.ArrayList;

import com.flui.db.Database.Data.DataObject;
import com.flui.db.Database.Data.InvalidKey;

public class Node {
    private ArrayList<Node> connections;
    private ArrayList<String> connectionTypes;
    DataObject data;

    public Node(DataObject data){
        this.data = data;
        connections = new ArrayList<>();
    }
    public void connect(Node other){
        connections.add(other);
        connectionTypes.add("");
    }
    public void connect(Node other, String connectionType){
        connectionTypes.add(connectionType);
        connections.add(other);
    }
    public void set(String key, DataObject value) throws InvalidKey {
        data.set(key,value);
    }
}
