package edu.sdsu.cursor;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;
import edu.sdsu.observer.CursorObserver;

public interface ICursor {
   Object get(String key);
   Integer getInt(String key);
   Double getDouble(String key);
   String getString(String key);
   ArrayType getArray(String key);
   ObjectType getObject(String key);
   void addObserver(CursorObserver cursorObserver);
   void removeObserver(CursorObserver cursorObserver);
}
