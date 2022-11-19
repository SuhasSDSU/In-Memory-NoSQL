package edu.sdsu.db;

import edu.sdsu.dataType.IDataType;
import edu.sdsu.exceptions.NoValueException;

//public interface IDatabase<T extends Object> {
public interface IDatabase {
//   void put(String key, IDataType value) throws NoValueException;
   void put(String key, Object value) throws NoValueException;
   Object get(String key);
   void getInt(String key);
   void getDouble(String key);
   void getString(String key);
   void getArray(String key);
   void getObject(String key);

   void remove(String key);
}
