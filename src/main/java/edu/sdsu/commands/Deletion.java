package edu.sdsu.commands;

import edu.sdsu.db.Database;
import java.util.Map;

public class Deletion implements IDatabaseCommand {

   private Object value;

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   private String key;
   public Deletion(String key){
      this.key = key;
   }
   @Override
   public Object execute(Database db) {
      Map<String, Object> database = db.getCollection();
      setKey(this.key);
      setValue(database.remove(key));
      return database.remove(key);
   }
   @Override
   public Object undo(Database db) {
      return db.put(getKey(), getValue());
   }

   @Override
   public String toString() {
      return "Deletion";
   }
}
