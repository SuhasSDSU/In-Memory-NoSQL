package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.memento.DatabaseMemento;

import java.util.List;
import java.util.Map;

public class SnapShotCreation implements ICommand{
   private Database db;
   @Override
   public Object execute(Database db) {

      DatabaseMemento memento = new DatabaseMemento(db, db.getCollection());
      return memento.createSnapshot();
   }

   @Override
   public Object undo(Database db) {
      DatabaseMemento memento = new DatabaseMemento(db, db.getCollection());
      return memento.deleteSnapshot();
   }
}
