package edu.sdsu.dataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdsu.exceptions.NoValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayType extends Object{
   private List<Object> listOfValues;
   private Object value;

   public ArrayType(){
      listOfValues = new ArrayList<>();
   }
   public ArrayType(List<Object> list){
      this.listOfValues = list;
   }
   public List<Object> getListOfValues() {
      return listOfValues;
   }
   public static Object fromString(String value) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(value, new TypeReference<List<Object>>(){});
   }

   public void put(Object value) throws NoValueException{
      if(value == null){
         throw new NoValueException("No Value to enter in database");
      }
      this.listOfValues.add(value);
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
      Object[] result = listOfValues.toArray();
      return Arrays.toString(result);
   }

   public void setListOfValues(List<Object> listOfValues) {
      this.listOfValues = listOfValues;
   }
}
