package edu.sdsu.memento;

import edu.sdsu.db.Database;

public class SnapShotHandler {
   private Database state;

   public void setState(Database state){
      this.state = state;
   }
   public DatabaseMemento saveToMemento(){
      return new DatabaseMemento(this.state);
   }

   public void getFromMemento(DatabaseMemento memento){
      state = memento.getState();
   }
}
