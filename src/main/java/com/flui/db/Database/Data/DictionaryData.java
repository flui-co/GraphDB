package com.flui.db.Database.Data;

import java.util.HashMap;

public class DictionaryData implements DataObject{
    
    HashMap<String,DataObject> dict;

    public DictionaryData(){
        dict = new HashMap<>();
    }

    public void set(String key, DataObject value) throws InvalidKey{
        if(key.contains(".")){
            String mykey = key.substring(
                0,
                key.indexOf(".")+1
            );
            String theirkey = key.substring(
                key.indexOf(".")+1
            );
            dict.get(mykey).set(theirkey, value);
        }else{
            dict.put(key, value);
        }
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
