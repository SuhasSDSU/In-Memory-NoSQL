package edu.sdsu.dataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayType {
   private static List<Object> listOfValues;
   private Object value;
   public ArrayType(){
      listOfValues = new ArrayList<>();
   }
   public ArrayType(Object value){
      this.value = value;
   }
   public ArrayType(List<Object> list){
      this.listOfValues = list;
   }
   public List<Object> getListOfValues() {
      return listOfValues;
   }
   public static Object fromString(String value) throws JsonMappingException, JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      List<Object> jsonObject = (mapper.readValue(value, List.class));
      listOfValues = jsonObject;
      return listOfValues;
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
      return Arrays.toString(this.listOfValues.toArray());
   }
}
