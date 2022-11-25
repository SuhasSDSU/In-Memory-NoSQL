package edu.sdsu.memento;

import edu.sdsu.commands.ICommand;
import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transaction implements ITransaction {
   //   private DatabaseMemento db;
   private Database db;
   private List<Map<String, Object>> stateOfDatabase;
   private Object value;

   private boolean isActive;

   public Transaction(Database db){
      this.db = db;
      this.isActive = true;
      this.stateOfDatabase = new ArrayList<>();
   }

   @Override
   public Database put(String key, Object value){
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return this.db.put(key, value);
   }

   @Override
   public Object get(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return this.db.getCollection().get(key);
   }

   @Override
   public Integer getInt(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return (Integer) this.db.getCollection().get(key);
   }

   @Override
   public Double getDouble(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return (Double) this.db.getCollection().get(key);
   }

   @Override
   public String getString(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return "";
   }

   @Override
   public ArrayType getArray(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return new ArrayType((List<Object>) this.db.getCollection().get(key));
   }

   @Override
   public ObjectType getObject(String key) {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return new ObjectType((Map<String, Object>)this.db.getCollection().get(key));
   }

   @Override
   public Object remove(String key){
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return this.db.remove(key);
   }

   @Override
   public void commit(){
      isActive = false;
   }

   @Override
   public void abort(){
      isActive = false;
   }
   @Override
   public boolean isActive() {
      return isActive;
   }

   public Object getValue() {
      if(isActive == false)throw new UnsupportedOperationException("Cannot perform operations");
      return value;
   }

}
