package edu.sdsu.dataType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ObjectType {
   private Object value;
   public ObjectType(Object value){
      this.value = value;
   }

   public static Object fromString(String value) throws JsonMappingException, JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      List<Object> jsonObject = Arrays.asList(mapper.readValue(value, Object.class));
      return jsonObject;
   }

   public void put(String key, Object value){

   }

   public Integer getInteger(String key){
      return 0;
   }

   public Double getDouble(String key){
      return 0.0;
   }

   public String getString(String key) {
      return "";
   }

   public ArrayType getArray(String key){
      return null;
   }

   public Object getObject(String key){
      return null;
   }

   public int length(){
      return 0;
   }

   @Override
   public String toString(){
      return this.value.toString();
   }
}
