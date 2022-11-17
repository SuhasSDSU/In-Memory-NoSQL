package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.db.IDatabase;

public interface ICommand {
   void execute(Database db);
   void undo(Database db);
}
