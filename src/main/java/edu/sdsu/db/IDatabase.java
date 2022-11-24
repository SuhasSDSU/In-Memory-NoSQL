package edu.sdsu.db;

import edu.sdsu.exceptions.NoValueException;

//public interface IDatabase<T extends Object> {
public interface IDatabase {
   Object put(String key, Object value) throws NoValueException;
   Object get(String key);
   Integer getInt(String key);
   Double getDouble(String key);
   String getString(String key);
   Object getArray(String key);
   Object getObject(String key);

   void remove(String key);
}
