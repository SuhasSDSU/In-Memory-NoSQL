package edu.sdsu.commands;

import edu.sdsu.db.Database;
import java.util.Map;

public class Deletion implements ICommand{

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
   public void execute(Database db) {
      Map<String, Object> database = db.getCollection();
      database.remove(key);
      setKey(this.key);
      setValue(database.remove(key));
   }

   @Override
   public void undo(Database db) {
      db.put(getKey(), getValue());
   }
}
