package edu.sdsu.memento;

import edu.sdsu.db.Database;

import java.util.ArrayList;
import java.util.List;

public class DataBaseMemento {
   List<Database> databaseHistory;
   public DataBaseMemento(){
      this.databaseHistory = new ArrayList<>();
   }
}
