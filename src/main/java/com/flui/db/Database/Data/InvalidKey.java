package com.flui.db.Database.Data;

public class InvalidKey extends Exception{
    private String key;
    public InvalidKey(String key){
        this.key = key;
    }

    public void print(){
        System.out.println("Invalid key to insert given value on: "+key);
        super.printStackTrace();
    }

}
