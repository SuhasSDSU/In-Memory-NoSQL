package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.memento.DatabaseCareTaker;
import edu.sdsu.memento.SnapShotHandler;

// Originator
public class SnapShotCreation implements ICommand{
   @Override
   public Object execute(Database db) {
      SnapShotHandler snapShotHandler = new SnapShotHandler();
      snapShotHandler.setState(db);
      DatabaseCareTaker databaseCareTaker = new DatabaseCareTaker();
      databaseCareTaker.add(snapShotHandler.saveToMemento());
      return null;
   }

   @Override
   public Object undo(Database db) {
      return null;
   }
}
