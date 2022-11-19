package edu.sdsu.dataType;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
   public List<Object> getArray() {
      return null;
   }

   @Override
   public Object getObject() {
      return this.value;
   }

   /**
    * Would convert the data as per the given constraint
    */

   private void fromString(){
      ObjectMapper mapper = new ObjectMapper();
      try {
         this.value = mapper.readValue((JsonParser) this.value, Object[].class);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public String toString(){
      fromString();
      return Objects.toString(this.value);
   }

}
