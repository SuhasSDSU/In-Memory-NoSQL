package edu.sdsu.commands;

import edu.sdsu.db.IDatabase;

public interface ICommand {
   void execute(IDatabase db);
   void undo(IDatabase db);
}
