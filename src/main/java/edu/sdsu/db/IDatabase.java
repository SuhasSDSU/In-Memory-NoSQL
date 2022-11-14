package edu.sdsu.db;

public interface IDatabase {
   boolean put(String key, Object value);
   void getInt(String key);
   void getDouble(String key);
   void getArray(String key);
   void getString(String key);
   void getObject(String key);
   void get(String key);
   void remove(String key);
}
