package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;

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
      db.getCommandHistory().add(this);
      Utils.storeCommandsInFile(db,Constants.COMMAND_FILE_PATH,Boolean.TRUE);
      return database.remove(String.valueOf(key));
   }

   @Override
   public Object undo(Database db) {
      db.put(getKey().toString(), getValue());
      return "Performed Undo on delete";
   }

   @Override
   public String toString() {
      return "Deleted:" + getKey();
   }
}
