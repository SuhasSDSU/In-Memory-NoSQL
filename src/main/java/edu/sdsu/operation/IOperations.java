package edu.sdsu.operation;

public interface IOperations<T extends Object> {
   boolean put(String key, T value);
   void getInt(String key);
   void getDouble(String key);
   void getArray(String key);
   void getString(String key);
   void getObject(String key);
   void get(String key);
}
