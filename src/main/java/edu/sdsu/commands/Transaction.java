package edu.sdsu.commands;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;

import java.util.List;
import java.util.Map;

public class Transaction implements ITransaction {
   private Database db;

   private boolean isActive;

   public Transaction(Database db){
      this.db = db;
      this.isActive = true;
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
      return db.getString(key);
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
      db.setCollection(this.db.getCollection());
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


}
