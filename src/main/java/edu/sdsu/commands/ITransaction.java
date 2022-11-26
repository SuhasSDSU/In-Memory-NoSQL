package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.exceptions.NoValueException;

public interface ITransaction {
   Database put(String key, Object value) throws NoValueException;
   Object get(String key);
   Integer getInt(String key);
   Double getDouble(String key);
   String getString(String key);
   Object getArray(String key);
   Object getObject(String key);
   Object remove(String key);
   void commit();
   void abort();
   boolean isActive();

}
