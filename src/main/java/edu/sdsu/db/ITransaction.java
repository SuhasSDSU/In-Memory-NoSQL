package edu.sdsu.db;

public interface ITransaction<T> {
   boolean put(String key, T val);
   void getInt(String key);
   void getDouble(String key);
   void getString(String key);
   void getArray(String key);
   void getObject(String key);

   void remove(String key);
   void commit();
   void abort();
   void isActive();
}
