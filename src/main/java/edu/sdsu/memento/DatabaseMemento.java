package edu.sdsu.memento;

import edu.sdsu.db.Database;
import edu.sdsu.exceptions.NoMomentoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseMemento {
   private Database db;
   private Map<String, Object> collection;

   private static List<Map<String, Object>> stateOfDatabase = new ArrayList<>();

   public DatabaseMemento(Database db){
      this.db = db;
   }
   public DatabaseMemento(Database db, Map<String, Object> collection){
      this.db = db;
      this.collection = collection;
   }
   public Object createSnapshot(){
      return this.stateOfDatabase.add(collection);
   }

   public Object deleteSnapshot(){
      if(this.getState().size() < 0 ){
         throw new NoMomentoException("No Snapshot Taken");
      }
      return this.stateOfDatabase.remove(this.stateOfDatabase.size()-1);
   }
   public List<Map<String, Object>> getState(){
      return this.stateOfDatabase;
   }

   public void displayData(){
      this.stateOfDatabase.forEach(e -> System.out.println(e));
   }
}
