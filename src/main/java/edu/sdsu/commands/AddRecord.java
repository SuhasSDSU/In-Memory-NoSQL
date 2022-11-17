package edu.sdsu.commands;

import edu.sdsu.dataType.IDataType;
import edu.sdsu.db.Database;
import java.util.Map;

public class AddRecord implements ICommand{

   private String key;
   private Object value;
   public AddRecord(String key, Object value){
      this.key = key;
      this.value = value;
   }
   @Override
   public void execute(Database db) {
//      Map<String, Object> temp = db.getCollection();
      Map<String, IDataType> temp = db.getCollection();
      temp.put(getKey(), (IDataType) getValue());
   }

   @Override
   public void undo(Database db) {

   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }
}
