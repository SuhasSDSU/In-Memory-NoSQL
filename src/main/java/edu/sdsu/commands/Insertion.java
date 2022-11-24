package edu.sdsu.commands;

import edu.sdsu.db.Database;
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
      System.out.println(getKey());
      return dbCollection.put(getKey(),  getValue());
   }

   @Override
   public void undo(Database db) {
      Map<String, Object> dbCollection = db.getCollection();
      dbCollection.remove(getKey());
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
      return "Insertion";
   }
}
