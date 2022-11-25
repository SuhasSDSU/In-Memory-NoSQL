package edu.sdsu.memento;

import edu.sdsu.db.Database;

public class SnapShotHandler {
   private Database state;
   public SnapShotHandler(Database db) {
      this.state = db;
   }

   public DatabaseMemento saveToMemento(){
      return new DatabaseMemento(this.state);
   }

   public void getFromMemento(DatabaseMemento memento){
      state = memento.getDb();
   }
}
