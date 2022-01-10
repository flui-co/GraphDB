package com.flui.db.Database.Data;

public class StringData implements DataObject{
    
    public StringData(String string) {
        
    }

    @Override
    public void set(String key, DataObject value) throws InvalidKey{
        throw new InvalidKey(key);
    }

    public void addChar(char c) {
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
