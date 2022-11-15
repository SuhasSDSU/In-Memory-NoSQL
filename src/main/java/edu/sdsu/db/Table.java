package edu.sdsu.db;
import java.util.Map;
import java.util.HashMap;

public class Table {
   Record record;
   Map<String, Map> collections;
   public Table(){
      collections = new HashMap<>();
      record = new Record();
   }


   public void add(String key, Object val){
      record.add(key, val);
      collections.put(String.valueOf(record.hashCode()), (Map) record.getRecord());
   }

   public Record getRecord() {
      return record;
   }

   public void setRecord(Record record) {
      this.record = record;
   }

   public Map<String, Map> getCollections() {
      return collections;
   }

   public void setCollections(Map<String, Map> collections) {
      this.collections = collections;
   }
}
