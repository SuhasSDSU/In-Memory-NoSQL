package edu.sdsu.db;
import edu.sdsu.commands.*;
import edu.sdsu.cursor.Cursor;
import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.exceptions.NoValueException;
import edu.sdsu.exceptions.WrongDataType;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Database implements IDatabase {
   Map<String, Object> collection;
   Object value;
   ICommand command;
   List<ICommand> commandHistory;

   public List<ICommand> getCommandHistory() {
      return commandHistory;
   }

   public Database(){
      this.collection = new HashMap<>();
      this.commandHistory = new ArrayList<>();
   }
   @Override
   public Database put(String key, Object value) throws NoValueException{
      if(value == null) {
         throw new NoValueException("No Value to enter in database");
      } else {
         command = new Insertion(key, value);
         command.execute(this);
      }
      return this;
   }
   @Override
   public Object get(String key) {
      return this.collection.get(key);
   }

   @Override
   public Integer getInt(String key) throws WrongDataType {
      if(!(this.collection.get(key).getClass().getSimpleName().equals("Integer"))){
         throw new WrongDataType("This is not Integer");
      }
      return (Integer) this.collection.get(key);
   }

   @Override
   public Double getDouble(String key) {
      if(!(this.collection.get(key).getClass().getSimpleName().equals("Double"))){
         throw new WrongDataType("This is not Double");
      }
      return (Double) this.collection.get(key);
   }

   @Override
   public String getString(String key) throws WrongDataType {
      if(!(this.collection.get(key).getClass().getSimpleName().equals("String"))){
         throw new WrongDataType("This is not String");
      }
      return (String) this.collection.get(key);
   }

   @Override
   public ArrayType getArray(String key) throws WrongDataType {
      if(!(this.collection.get(key).getClass().getSimpleName().equals("ArrayList"))){
         throw new WrongDataType("This is not ArrayType");
      }
      return new ArrayType((List<Object>) this.collection.get(key));
   }

   /**
    * Checks the datatype provided which would be in either Object or LinkedHashMap
    * @param key
    * @return
    */
   @Override
   public ObjectType getObject(String key) throws WrongDataType{
      boolean objectComparator = this.collection.get(key).getClass().getSimpleName().equals("Object");
      boolean mapComparator = this.collection.get(key).getClass().getSimpleName().equals("LinkedHashMap");
      if(! (objectComparator || mapComparator)){
         throw new WrongDataType("This is not ObjectType");
      }
      return new ObjectType((Map<String, Object>)this.collection.get(key));
   }

   @Override
   public Object remove(String key){
      command = new Deletion(key);
      return command.execute(this);
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public Map<String, Object> getCollection() {
      return collection;
   }
   //set this as protected
   public void setCollection(Map<String, Object> collection) {
      this.collection = collection;
   }

   public Transaction getTransaction(){
      return new Transaction(this);
   }

   public int getDataSize(){
      return this.collection.size();
   }

   public void createSnapShot(){
      SnapShotCreation snapShotCreation = new SnapShotCreation();
      snapShotCreation.execute(this);

   }
   public static void createSnapShot(File commands, File snapShot){
      SnapShotCreation snapShotCreation = new SnapShotCreation(commands, snapShot);
      snapShotCreation.execute(new Database());
   }

   public void recover(){
      // read from the file
      ReadSnapShot readSnapShot = new ReadSnapShot();
      readSnapShot.execute(this);
   }

   public static void recover(File commands, File snapShot){
      ReadSnapShot readSnapShot = new ReadSnapShot(commands, snapShot);
      readSnapShot.execute(new Database());
   }

   public Cursor getCursor(String key){
         return new Cursor(this, key);
   }

}
