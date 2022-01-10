package com.flui.db.Database.Data;

public interface DataObject {

    public void set(String key, DataObject value) throws InvalidKey;
    public void delete(String key);
    public boolean matches(DictionaryData query);
    public DataObject find(DictionaryData query);
    
}
