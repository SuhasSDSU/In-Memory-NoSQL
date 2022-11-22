package edu.sdsu.dataType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectType {
   private Object value;

   private static Map<String, Object> objects;

   public ObjectType(){}
   public ObjectType(Map<String, Object> map){
      objects = map;
   }
   public ObjectType(Object value) {
      this.value = value;
      this.objects = new HashMap<>();
   }

   public void put(String key, Object value){
      objects.put(key, value);
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
      return objects.get(key);
   }

   public int length(){
      return 0;
   }

   @Override
   public String toString(){
      String mapAsString = objects.keySet().stream()
            .map(key -> key + "=" + objects.get(key))
            .collect(Collectors.joining(", ", "{", "}"));
      return mapAsString;
   }

   /**
    * Might need to change here
    * @param value
    * @return
    * @throws JsonProcessingException
    */
   public static Object fromString(String value) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      Map<String, Object> jsonObject = mapper.readValue(value, Map.class);
      objects = jsonObject;
      return objects;
   }


}
