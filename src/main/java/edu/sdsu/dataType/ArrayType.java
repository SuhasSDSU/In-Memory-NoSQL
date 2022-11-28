package edu.sdsu.dataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdsu.commands.Deletion;
import edu.sdsu.commands.ICommand;
import edu.sdsu.commands.Insertion;
import edu.sdsu.db.Database;
import edu.sdsu.exceptions.NoValueException;
import edu.sdsu.exceptions.WrongDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayType {
   private List<Object> listOfValues;
   private static String key;
   private static Database dbRef;
   public ArrayType(){
      listOfValues = new ArrayList<>();
   }

   public ArrayType(String key, Database db){
      this.key = key;
      this.dbRef = db;
   }
   public ArrayType(List<Object> list){
      this.listOfValues = list;
   }

   public List<Object> getListOfValues() {
      return listOfValues;
   }
   public static Object fromString(String value) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      List<Object> jsonObject = mapper.readValue(value, new TypeReference<List<Object>>(){});
      return jsonObject;
   }

   public Object put(Object value) throws NoValueException{
      if(value == null){
         throw new NoValueException("No Value to enter in database");
      }
      this.listOfValues.add(value);
      ICommand command = new Insertion(this.key, getListOfValues());
      dbRef.getCommandHistory().add(command);
      return command.execute(this.dbRef);
   }

   public Object remove(int key){
      ICommand command = new Deletion(key);
      dbRef.getCommandHistory().add(command);
      return command.execute(this.dbRef);
   }

   public Integer getInt(Integer index) throws WrongDataType{
      if((this.listOfValues.get(index).getClass().getSimpleName().equals("Integer")) == false){
         throw new WrongDataType("This is not Integer");
      }
      return (Integer) listOfValues.get(index);
   }
   public Double getDouble(Integer index) {
      if(!(this.listOfValues.get(index).getClass().getSimpleName().equals("Double"))){
         throw new WrongDataType("This is not Integer");
      }
      return (Double) listOfValues.get(index);
   }
   public String getString(Integer index) {
      if(!(this.listOfValues.get(index).getClass().getSimpleName().equals("String"))){
         throw new WrongDataType("This is not String");
      }
      return listOfValues.get(index).toString();
   }

   public Object getObject(Integer index) {
      if(!(this.listOfValues.get(index).getClass().getSimpleName().equals("Object"))){
         throw new WrongDataType("This is not an Object");
      }
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
}