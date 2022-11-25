package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.memento.DatabaseMemento;

public class DeleteSnapShot implements ICommand{

   @Override
   public Object undo(Database db) {
      DatabaseMemento memento = new DatabaseMemento(db, db.getCollection());
      return memento.createSnapshot();
   }

   @Override
   public Object execute(Database db) {
      DatabaseMemento memento = new DatabaseMemento(db);
      return memento.deleteSnapshot();
   }
}
