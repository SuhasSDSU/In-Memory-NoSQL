package edu.sdsu.commands;

import edu.sdsu.dataType.IDataType;
import edu.sdsu.dataconverter.IConverter;
import edu.sdsu.db.Database;
import java.util.Map;

public class AddRecord implements ICommand{

   IConverter converter;
   private String key;
   private Object value;
//   private IDataType value;
   public AddRecord(String key, Object value){
//   public AddRecord(String key, IDataType value){
      this.key = key;
      this.value = value;
   }
   @Override
   public void execute(Database db) {
//      Map<String, IDataType> temp = db.getCollection();
      Map<String, Object> temp = db.getCollection();
      temp.put(getKey(),  getValue());
   }

   @Override
   public void undo(Database db) {
//      Map<String, IDataType> temp = db.getCollection();
      Map<String, Object> temp = db.getCollection();
      temp.remove(getKey());
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public Object getValue() {
//   public IDataType getValue() {
      return value;
   }

   public void setValue(Object value) {
//   public void setValue(IDataType value) {
      this.value = value;
   }
}
