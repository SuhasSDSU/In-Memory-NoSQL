package edu.sdsu.dataType;

import java.util.List;
public class ArrayType implements IDataType{

   private Object value;
   public ArrayType(Object value){
      this.value = value;
   }
   @Override
   public Integer getInt() {
      return 0;
   }

   @Override
   public Double getDouble() {
      return 0.0;
   }

   @Override
   public String getString() {
      return "";
   }

   @Override
   public List getArray() {
      return null;
   }

   @Override
   public Object getObject() {
      return this.value;
   }
}
