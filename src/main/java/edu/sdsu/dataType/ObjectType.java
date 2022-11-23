package edu.sdsu.dataType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class ObjectType {
   private Object values;

   private Map<String, Object> objects;

   public ObjectType(){
      this.objects = new HashMap<>();
   }
   public ObjectType(Map<String, Object> map){
      this.objects = map;
   }
   public ObjectType(Object value) {
      this.values = value;
      this.objects = new HashMap<>();
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

   public static Object fromString(String value) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      Map<String, Object> jsonObject = mapper.readValue(value, new TypeReference<Map<String,Object>>(){});
//      Object jsonObject = mapper.readValue(value, Object.class);
      jsonObject.forEach((key, val)-> out.println("key:"+key+"\t value:"+val));
      return jsonObject;
   }

   public void put(String key, Object value){
      objects.put(key, value);
   }


}
