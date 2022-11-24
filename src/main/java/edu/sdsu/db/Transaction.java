package edu.sdsu.db;

import edu.sdsu.commands.Deletion;
import edu.sdsu.commands.ICommand;
import edu.sdsu.commands.Insertion;
import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.exceptions.NoValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transaction {
   private Database db;
   private List<ICommand> commandHistory;
   private Object value;

   private boolean isActive;

   public Transaction(Database db){
      this.db = db;
      commandHistory = new ArrayList<>();
      this.isActive = false;
   }

   public Database put(String key, Object value) throws NoValueException {
      if(isActive == true)throw new UnsupportedOperationException("Cannot perform operations");
      if(value == null){
         throw new NoValueException("No Value to enter in database");
      }
      ICommand command = new Insertion(key, value);
      commandHistory.add(command);
      command.execute(this.db);
      return this.db;
   }
   public Object get(String key) {
      return this.db.getCollection().get(key);
   }

   public Integer getInt(String key) {
      return (Integer) this.db.getCollection().get(key);
   }

   public Double getDouble(String key) {
      return (Double) this.db.getCollection().get(key);
   }

   public String getString(String key) {
      return "";
   }

   public ArrayType getArray(String key) {
      return new ArrayType((List<Object>) this.db.getCollection().get(key));
   }

   public ObjectType getObject(String key) {
      return new ObjectType((Map<String, Object>)this.db.getCollection().get(key));
   }

   public void remove(String key){
      if(isActive == true)throw new UnsupportedOperationException("Cannot perform operations");
      ICommand command = new Deletion(key);
      command.execute(this.db);
      commandHistory.add(command);
   }

   public void commit(){
      isActive = true;
   }

   public void abort(){
      isActive = true;
   }

   public boolean isActive() {
      return isActive;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

}
