package edu.sdsu.db;
import java.util.HashMap;
import java.util.Map;
public class Database implements IDatabase {
   Map<String, Object> collection;

   public Database(){
      this.collection = new HashMap<>();
   }
   @Override
   public void put(String key, Object value) {
      collection.put(key, value);
   }

   public Map<String, Object> getCollection() {
      return collection;
   }

   public void setCollection(Map<String, Object> collection) {
      this.collection = collection;
   }
}
