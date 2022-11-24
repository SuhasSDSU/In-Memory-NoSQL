package edu.sdsu.dataType;

import java.util.List;

// do we need to extend this with Generics and Object
public interface IDataType{

   //   Object get();
   Integer getInt(Object key);
   Double getDouble(Object key);
   String getString(Object key);
   Object getObject(Object key);
   ArrayType getArray(Object key);

}