package edu.sdsu.cursor;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;
import edu.sdsu.observer.CursorObserver;

import java.util.ArrayList;
import java.util.List;

public class Cursor implements ICursor{
   private List<CursorObserver> observers = new ArrayList<>();
   private Database state;
   private String key;
   public Cursor(Database database){
      this.state = database;
   }

   public Cursor(Database database, String key){
      this.state = database;
      this.key = key;
      this.observers = new ArrayList<>();
   }

   @Override
   public Object get(String key) {
      return this.state.get(key);
   }

   @Override
   public Integer getInt(String key) {
      return state.getInt(key);
   }

   @Override
   public Double getDouble(String key) {
      return state.getDouble(key);
   }

   @Override
   public String getString(String key) {
      return state.getString(key);
   }

   @Override
   public ArrayType getArray(String key) {
      return state.getArray(key);
   }

   @Override
   public ObjectType getObject(String key) {
      return state.getObject(key);
   }
   @Override
   public void addObserver(CursorObserver observer) {
      this.observers.add(observer);

   }
   public Object value(){
      return this.state.getCollection().get(this.key);
   }

   @Override
   public void removeObserver(CursorObserver observer) {
      this.observers.remove(observer);
   }
   public void notifyObservers(){
      this.observers.forEach(observer -> observer.update(this.state));
   }
}
