package edu.sdsu.db;

public interface ICursor {
   void getInt(String key);
   void getDouble(String key);
   void getString(String key);
   void getArray(String key);
   void getObject(String key);

   void get(String key);
   void addObserver();// Observer here in params
   void removeObserver();// Observer here in params
}
