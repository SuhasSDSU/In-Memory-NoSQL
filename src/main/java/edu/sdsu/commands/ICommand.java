package edu.sdsu.commands;

import edu.sdsu.db.Database;

public interface ICommand {
   Object execute(Database db);
   Object undo(Database db);
}
