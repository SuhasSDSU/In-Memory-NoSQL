package edu.sdsu.commands;

import edu.sdsu.db.Database;
import java.util.Map;

public class DeleteRecord implements ICommand{

   private String key;
   public DeleteRecord(String key){
      this.key = key;
   }
   @Override
   public void execute(Database db) {
      Map<String, Object> database = db.getCollection();
      System.out.println(database.remove(key));
   }

   @Override
   public void undo(Database db) {

   }
}
