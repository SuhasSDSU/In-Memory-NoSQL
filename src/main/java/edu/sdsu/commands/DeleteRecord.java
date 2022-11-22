package edu.sdsu.commands;

import edu.sdsu.dataType.IDataType;
import edu.sdsu.db.Database;
import java.util.Map;

public class DeleteRecord implements ICommand{

   private Object value;

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   private String key;
   public DeleteRecord(String key){
      this.key = key;
   }
   @Override
   public void execute(Database db) {
      Map<String, Object> database = db.getCollection();
      setKey(this.key);
      setValue(database.remove(key));
   }

   @Override
   public void undo(Database db) {
      Map<String, Object> database = db.getCollection();
      db.put(getKey(), getValue());
   }
}
