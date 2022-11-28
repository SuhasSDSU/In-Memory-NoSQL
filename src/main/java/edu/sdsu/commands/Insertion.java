package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;

import java.util.Map;

public class Insertion implements ICommand{
   private String key;
   private Object value;

   public Insertion(){
      // for initialization purpose
   }
   public Insertion(String key, Object value){
      this.key = key;
      this.value = value;
   }

   @Override
   public Object execute(Database db) {
      Map<String, Object> dbCollection = db.getCollection();
      db.getCommandHistory().add(this);
      Utils.storeCommandsInFile(db, Constants.COMMAND_FILE_PATH, Boolean.TRUE);
      return dbCollection.put(getKey(),  getValue());
   }

   @Override
   public Object undo(Database db) {
      Map<String, Object> dbCollection = db.getCollection();
      dbCollection.remove(getKey());
      return null;
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   @Override
   public String toString() {
      return "Insert "+ getKey() + ":"+getValue();
   }
}
