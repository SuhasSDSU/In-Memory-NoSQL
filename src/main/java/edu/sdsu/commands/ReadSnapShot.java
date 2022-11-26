package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;

public class ReadSnapShot implements ICommand{
   @Override
   public Object execute(Database db) {
      Utils.readFromFile(Constants.DATABASE_FILE_PATH);
      return "SnapShot Created";
   }

   @Override
   public Object undo(Database db) {
      return null;
   }
}
