package edu.sdsu.memento;


import java.util.Stack;

public class DatabaseCareTaker {
   private Stack<DatabaseMemento> mementos = new Stack<>();
   public void add(DatabaseMemento databaseMemento){
      mementos.add(databaseMemento);
   }
   public DatabaseMemento get(){
      return mementos.pop();
   }
}
