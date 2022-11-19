package edu.sdsu.dataType;

import java.util.List;

public class IntegerType implements IDataType{

   private Integer value;
   public IntegerType(int value){
      this.value = value;
   }
   @Override
   public Integer getInt() {
      return this.value;
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
      return null;
   }

   public String toString(){
      return String.valueOf(this.value);
   }
}
