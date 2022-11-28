package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;

import java.io.File;

public class ReadSnapShot implements ICommand{

   File commands, snapShot;
   public ReadSnapShot(){}
   public ReadSnapShot(File commands, File snapShot) {
      this.commands = commands;
      this.snapShot = snapShot;
   }
   @Override
   public Object execute(Database db) {
      Utils.readFromFile(Constants.DATABASE_FILE_PATH);
      Utils.readFromFile(Constants.COMMAND_FILE_PATH);
      return "SnapShot Created";
   }

   @Override
   public Object undo(Database db) {
      return null;
   }
}
