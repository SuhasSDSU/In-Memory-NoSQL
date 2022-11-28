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

   public Object getKey() {
      return key;
   }

   public void setKey(Object key) {
      this.key = key;
   }
   private Object key;
   public Deletion(Object key){
      this.key = key;
   }
   @Override
   public Object execute(Database db) {
      Map<String, Object> database = db.getCollection();
      setKey(String.valueOf(this.key));
      setValue(database);
      if(database.get(String.valueOf(key)) == null){
         undo(db);
      }
      return database.remove(String.valueOf(key));
   }

   @Override
   public Object undo(Database db) {
      db.put(getKey().toString(), getValue());
      return "Delete Undo";
   }

   @Override
   public String toString() {
      return "Deleted:" + getKey();
   }
}
