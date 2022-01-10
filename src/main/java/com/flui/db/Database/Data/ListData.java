package com.flui.db.Database.Data;

import java.util.ArrayList;

public class ListData implements DataObject{

    ArrayList<DataObject> list;

    public ListData(){
        list = new ArrayList<>();
    }

    @Override
    public void set(String key, DataObject value) throws InvalidKey{
        throw new InvalidKey(key);
    }

    public void push(DataObject data) {
        list.add(data);
    }

    @Override
    public void delete(String key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean matches(DictionaryData query) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DataObject find(DictionaryData query) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
