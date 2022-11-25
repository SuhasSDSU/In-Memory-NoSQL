package edu.sdsu.commands;

import edu.sdsu.db.Database;

public class DeleteSnapShot implements ICommand{

   @Override
   public Object undo(Database db) {
      return null;
   }

   @Override
   public Object execute(Database db) {
      return null;
   }
}
