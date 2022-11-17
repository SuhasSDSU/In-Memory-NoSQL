package edu.sdsu.db;
import edu.sdsu.commands.ICommand;

import java.util.HashMap;
import java.util.Map;
public class Database implements IDatabase {
   Map<String, Object> collection;
   ICommand command;
   public Database(){
      this.collection = new HashMap<>();
   }
   @Override
   public void put(String key, Object value) {
      collection.put(key, value);
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

   public Map<String, Object> getCollection() {
      return collection;
   }

   public void setCollection(Map<String, Object> collection) {
      this.collection = collection;
   }
}
