package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;


public class SnapShotCreation implements ICommand{
   @Override
   public Object execute(Database db) {
      Utils.writeToFile(db, Constants.DATABASE_FILE_PATH, Boolean.TRUE);
      return null;
   }

   @Override
   public Object undo(Database db) {
      return null;
   }
}
