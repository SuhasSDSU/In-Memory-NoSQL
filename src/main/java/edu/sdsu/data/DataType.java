package edu.sdsu.data;

public interface DataType<T extends Object> {
   void put(String key, T value);
   void getDouble(String key);
   void getInt(String key);
   void getArray(String key);
   void getString(String key);
   void getObject(String key);
   void get(int index);
   int length();
   void remove(int index);
}
