package edu.sdsu.dataType;

import java.util.List;

public class IntegerType implements IDataType{

   private Object value;
   public IntegerType(Object value){
      this.value = value;
   }
   @Override
   public Integer getInt() {
      return (Integer) this.value;
   }

   @Override
   public Double getDouble() {
      return null;
   }

   @Override
   public String getString() {
      return null;
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
