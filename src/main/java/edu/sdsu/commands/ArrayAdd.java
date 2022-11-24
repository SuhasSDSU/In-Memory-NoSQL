package edu.sdsu.commands;

import edu.sdsu.db.Database;
import edu.sdsu.exceptions.NoValueException;

import java.util.List;

public class ArrayAdd implements IDatabaseCommand{
   String key;
   Object value;

   List<Object> beforeOperationList;

   public ArrayAdd(){}
   public ArrayAdd(String key, Object value){
      this.key = key;
      this.value = value;
   }
   @Override
   public Object execute(Database db) {
      if(value == null){
         throw new NoValueException("No Value to enter in database");
      }
      this.beforeOperationList =  db.getArray(key).getListOfValues();
      this.setListBeforeOperation(this.beforeOperationList);
      return db.getArray(key).getListOfValues().add(value);
   }

   @Override
   public Object undo(Database db) {
       db.getArray(key).setListOfValues(getListBeforeOperation());
       return true;
   }

   public List<Object> getListBeforeOperation() {
      return beforeOperationList;
   }

   public void setListBeforeOperation(List<Object> beforeOperationList) {
      this.beforeOperationList = beforeOperationList;
   }
}
