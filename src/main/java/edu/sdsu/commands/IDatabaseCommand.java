package edu.sdsu.commands;

import edu.sdsu.db.Database;

public interface IDatabaseCommand {
   Object execute(Database db);
   Object undo(Database db);
}
