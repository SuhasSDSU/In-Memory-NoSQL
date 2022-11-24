package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.db.IDatabase;

import java.util.Map;

public class FetchRecord implements IDatabaseCommand {

   private Object value;
   private String key;
   public FetchRecord(String key) {
      this.key = key;
   }

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

   public Object execute(Database db){
      return getData(db);
   }


   private Object getData(Database db){
      return db.getCollection().get(key);
   }

   @Override
   public Object undo(Database db) {
    return null;
   }

   @Override
   public String toString() {
      return "Get Records";
   }
}
