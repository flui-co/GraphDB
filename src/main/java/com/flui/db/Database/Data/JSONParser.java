package com.flui.db.Database.Data;

//Recursive descent json parser
public class JSONParser {

    int on;
    char[] s;
    
    public JSONParser(){
        on = 0;
    }

    public void match(char c) throws Exception{
        if(s[on] == c){
            on++;
            return;
        }else{
            System.out.println("Parse error - unexpected: "+s[on]+"at position: "+on);
            throw new Exception();
        }
    }
    public void match_any(){
        on++;
    }

    public DataObject parse(String str){
        on = 0;
        s = str.toCharArray();
        try{
            return data();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public DictionaryData dict() throws Exception{
        DictionaryData ret = new DictionaryData();
        match('{');
        while(s[on] != '}'){
            String k = key();
            match(':');
            DataObject dat = data();
            if(s[on]!='}'){
                match(',');
            }
            ret.set(k,dat);
        }
        match('}');
        return ret;
    }
    public StringData string() throws Exception{
        StringData ret = new StringData("");
        match('"');
        while(s[on]!='"'){
            ret.addChar(s[on]);
            match_any();
        }
        match('"');
        return ret;

    }
    public ListData list() throws Exception{ 
        match('[');
        ListData ret = new ListData();
        while(s[on]!=']'){
            ret.push(
                data()
            );
            if(s[on]!=']'){
                match(',');
            }
        }
        match(']');
        return ret;
    }
    public String key() throws Exception{
        String ret = "";
        match('"');
        while(s[on]!='"'){
            ret+=s[on];
            match_any();
        }
        match('"');
        return ret;
    }
    public DataObject data() throws Exception{
        if(s[on] == '"'){
            return string();
        }else if(s[on]=='{'){
            return dict();
        }else if(s[on] == '['){
            return list();
        }else{
            System.out.println("Parse error - unexpected data field starting char: "+s[on]+"at position: "+on);
            throw new Exception();
        }
    }

}
