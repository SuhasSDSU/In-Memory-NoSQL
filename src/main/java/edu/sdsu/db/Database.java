package edu.sdsu.db;

import edu.sdsu.commands.FetchRecord;
import edu.sdsu.commands.Insertion;
import edu.sdsu.commands.Deletion;
import edu.sdsu.commands.IDatabaseCommand;
import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.exceptions.NoValueException;

import java.util.*;

public class Database implements IDatabase {
   Map<String, Object> collection;
   String key;
   Object value;
   IDatabaseCommand command;

   List<IDatabaseCommand> commandHistory;

   public List<IDatabaseCommand> getCommandHistory() {
      return commandHistory;
   }

   public void setCommandHistory(List<IDatabaseCommand> commandHistory) {
      this.commandHistory = commandHistory;
   }

   public Database(){
      this.collection = new HashMap<>();
      this.commandHistory = new ArrayList<>();
   }

   @Override
   public Object put(String key, Object value) throws NoValueException{
      if(value == null){
         throw new NoValueException("No Value to enter in database");
      }
      command = new Insertion( key, value);
      commandHistory.add(command);
      return command.execute(this);
   }
   @Override
   public Object get(String key) {
      command = new FetchRecord(key);
      commandHistory.add(command);
      return command.execute(this);
   }

   @Override
   public Integer getInt(String key) {
      return (Integer) this.collection.get(key);
   }

   @Override
   public Double getDouble(String key) {
      return (Double) this.collection.get(key);
   }

   @Override
   public String getString(String key) {
      return "";
   }

   @Override
   public ArrayType getArray(String key) {
      return new ArrayType((List<Object>) this.collection.get(key));
   }

   @Override
   public ObjectType getObject(String key) {
      return new ObjectType((Map<String, Object>)this.collection.get(key));
   }

   @Override
   public void remove(String key){
      command = new Deletion(key);
      command.execute(this);
      commandHistory.add(command);
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

}
