package edu.sdsu.db;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.exceptions.NoValueException;
import edu.sdsu.observer.IObserver;

//public interface IDatabase<T extends Object> {
public interface IDatabase {
   Database put(String key, Object value) throws NoValueException;
   Object get(String key);
   Integer getInt(String key);
   Double getDouble(String key);
   String getString(String key);
   ArrayType getArray(String key);
   ObjectType getObject(String key);
   Object remove(String key);

}
