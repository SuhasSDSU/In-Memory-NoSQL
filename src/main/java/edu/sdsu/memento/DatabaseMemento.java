package edu.sdsu.memento;

import edu.sdsu.db.Database;

public class DatabaseMemento {
   private Database db;
   public DatabaseMemento(Database db){
      this.db = db;
   }
   public Database getState() {
      return db;
   }
}
