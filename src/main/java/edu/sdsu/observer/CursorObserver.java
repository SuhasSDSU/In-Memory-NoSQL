package edu.sdsu.observer;

import edu.sdsu.db.Database;
public class CursorObserver implements IObserver{
   //State
   Database database;
   public CursorObserver(Database database){
      this.database = database;

   }
   public Database getDatabase() {
      return database;
   }

   @Override
   public void update(Database database) {
      System.out.println("Observer notified");
      this.database = database;
   }

   @Override
   public String toString() {
      return this.database.getCollection().toString();
   }
}
