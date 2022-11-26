package edu.sdsu.observer;

import edu.sdsu.db.Database;

public interface IObserver {
   void update(Database database);
}
