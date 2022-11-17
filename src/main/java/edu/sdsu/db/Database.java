package edu.sdsu.db;
import edu.sdsu.commands.AddRecord;
import edu.sdsu.commands.DeleteRecord;
import edu.sdsu.commands.ICommand;
import edu.sdsu.exceptions.NoValueException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Database implements IDatabase {
   Map<String, Object> collection;
   String key;
   Object value;
   ICommand command;

   List<ICommand> commandHistory;

   public List<ICommand> getCommandHistory() {
      return commandHistory;
   }

   public void setCommandHistory(List<ICommand> commandHistory) {
      this.commandHistory = commandHistory;
   }

   public Database(){
      this.collection = new HashMap<>();
      this.commandHistory = new ArrayList<>();
   }
   @Override
   public void put(String key, Object value) throws NoValueException{
      command = new AddRecord( key, value);
      if(value == null){
         throw new NoValueException("No Value to enter");
      }
      command.execute(this);
      commandHistory.add(command);
   }
   @Override
   public Object get(String key) {
      return this.collection.get(key);
   }

   @Override
   public void getInt(String key) {

   }

   @Override
   public void getDouble(String key) {

   }

   @Override
   public void getString(String key) {

   }

   @Override
   public void getArray(String key) {

   }

   @Override
   public void getObject(String key) {

   }

   @Override
   public void remove(String key){
      command = new DeleteRecord(key);
      command.execute(this);
      commandHistory.add(command);
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public Map<String, Object> getCollection() {
      return collection;
   }

   public void setCollection(Map<String, Object> collection) {
      this.collection = collection;
   }
}
