package edu.sdsu.dataType;
import java.util.List;
import java.util.Objects;

public class ArrayType implements IDataType{
   private String value;

   public ArrayType(String value){
      this.value = value;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(String value) {
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
   public List<Object> getArray() {
      return null;
   }

   @Override
   public Object getObject() {
      return this.value;
   }

   public String toString(){
      return Objects.toString(this.value);
   }

   public void fromString(String value) throws Exception{
      setValue(value);
   }

}
