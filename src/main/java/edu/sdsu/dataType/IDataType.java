package edu.sdsu.dataType;

import java.util.List;

// do we need to extend this with Generics and Object
public interface IDataType{
   Integer getInt();
   Double getDouble();
   String getString();
   List getArray();
   Object getObject();
   String toString();

}
