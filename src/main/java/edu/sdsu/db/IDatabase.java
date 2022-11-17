package edu.sdsu.db;

public interface IDatabase<T extends Object> {
   void put(String key, T value);
   Object get(String key);
   void getInt(String key);
   void getDouble(String key);
   void getString(String key);
   void getArray(String key);
   void getObject(String key);
}
