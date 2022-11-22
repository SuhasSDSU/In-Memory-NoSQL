package edu.sdsu.dataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayType {
   private List<Object> listOfValues;

   public ArrayType(){
      this.listOfValues = new ArrayList<>();
   }
   public List<Object> getListOfValues() {
      return listOfValues;
   }

   public void setListOfValues(List<Object> listOfValues) {
      this.listOfValues = listOfValues;
   }

   public static Object fromString(Object value) throws JsonMappingException, JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      String json = "[12,321123,21]";
      List<Object> jsonObject = Arrays.asList(mapper.readValue(json, Object.class));
      return jsonObject;
   }

   public void put(Object value){
      listOfValues.add(value);
   }
   public Integer getInt(Integer index) {
      return (Integer) listOfValues.get(index);
   }
   public Double getDouble(Integer index) {
      return (Double) listOfValues.get(index);
   }
   public String getString(Integer index) {
      return listOfValues.get(index).toString();
   }

   public Object getObject(Integer index) {
      return this.listOfValues.get(index);
   }
   public int length(){
      return this.listOfValues.size();
   }
   @Override
   public String toString(){
      return this.listOfValues.toArray().toString();
   }
}
