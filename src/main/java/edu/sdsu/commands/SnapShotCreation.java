package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.utils.Constants;
import edu.sdsu.utils.Utils;

import java.io.File;


public class SnapShotCreation implements ICommand{

   File commands, snapShot;
   public SnapShotCreation(){}
   public SnapShotCreation(File commands, File snapShot) {
      this.commands = commands;
      this.snapShot = snapShot;
   }

   @Override
   public Object execute(Database db) {
      Utils.storeDatabaseInFile(db, Constants.DATABASE_FILE_PATH, Boolean.TRUE);
      Utils.storeCommandsInFile(db, Constants.COMMAND_FILE_PATH, Boolean.TRUE);
      return "SnapShot Created";
   }

   @Override
   public Object undo(Database db) {
      Utils.delete(Constants.COMMAND_FILE_PATH);
      Utils.delete(Constants.DATABASE_FILE_PATH);
      return "Snapshot deleted";
   }
}
