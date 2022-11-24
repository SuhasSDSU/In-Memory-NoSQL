package edu.sdsu.dataType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdsu.commands.Deletion;
import edu.sdsu.commands.ICommand;
import edu.sdsu.commands.Insertion;
import edu.sdsu.db.Database;
import edu.sdsu.exceptions.WrongDataType;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class ObjectType {
   private static String key;
   private static Database dbRef;
   private Map<String, Object> objects;

   public Map<String, Object> getObjects() {
      return objects;
   }

   public ObjectType(){
      this.objects = new HashMap<>();
   }
   public ObjectType(Map<String, Object> map){
      this.objects = map;
   }

   public ObjectType(Database db, String key){
      this.key = key;
      dbRef = db;
   }

   public Integer getInteger(String key){
      if(!(objects.get(key).getClass().getSimpleName().equals("Integer"))){
         throw new WrongDataType("This is not Integer");
      }
      return (Integer) objects.get(key);
   }

   public Double getDouble(String key){
      if(!(objects.get(key).getClass().getSimpleName().equals("Double"))){
         throw new WrongDataType("This is not Double");
      }
      return (Double) objects.get(key);
   }

   public String getString(String key) {
      if(!(objects.get(key).getClass().getSimpleName().equals("String"))){
         throw new WrongDataType("This is not String");
      }
      return (String) objects.get(key);
   }

   public Object getArray(String key){
      if((this.objects.get(key).getClass().getSimpleName().equals("ArrayList")) == false){
         throw new WrongDataType("This is not ArrayType");
      }
      return objects.get(key);
   }
   public Object getObject(String key){
      boolean ObjectComparator = this.objects.get(key).getClass().getSimpleName().equals("Object");
      boolean MapComparator = this.objects.get(key).getClass().getSimpleName().equals("LinkedHashMap");
      if(! (ObjectComparator || MapComparator)){
         throw new WrongDataType("This is not ObjectType");
      }
      return objects.get(key);
   }

   public int length(){
      return 0;
   }

   @Override
   public String toString(){
      String mapAsString = objects.keySet().stream()
            .map(key -> key + ":" + objects.get(key))
            .collect(Collectors.joining(", ", "{", "}"));
      return mapAsString;
   }

   public static Object fromString(String value) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      Map<String, Object> jsonObject = mapper.readValue(value, new TypeReference<Map<String,Object>>(){});
      return jsonObject;
   }

   public Object put(String key, Object value){
      objects.put(key, value);
      ICommand command = new Insertion(this.key, getObjects());
      dbRef.getCommandHistory().add(command);
      return command.execute(dbRef);
   }

   public Object remove(String key){
      ICommand command = new Deletion(key);
      dbRef.getCommandHistory().add(command);
      return command.execute(this.dbRef);
   }

}
