package edu.sdsu.db;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.exceptions.NoValueException;
import edu.sdsu.exceptions.WrongDataType;
import edu.sdsu.observer.IObserver;

//public interface IDatabase<T extends Object> {
public interface IDatabase {
   Database put(String key, Object value) throws NoValueException;
   Object get(String key) throws WrongDataType;
   Integer getInt(String key) throws WrongDataType;
   Double getDouble(String key) throws WrongDataType;
   String getString(String key) throws WrongDataType;
   ArrayType getArray(String key) throws WrongDataType;
   ObjectType getObject(String key) throws WrongDataType;
   Object remove(String key);

}
