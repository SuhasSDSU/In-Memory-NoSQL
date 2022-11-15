package edu.sdsu.db;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Record <T extends Object >{
   Date createdAt;
   Map<String, T> record;
   public Record(){
      this.createdAt = new Date();
      record = new HashMap<String, T>();
   }

   public void add(String key, Object value){
      record.put(key, (T) value);
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public Map<String, T> getRecord() {
      return record;
   }

   public void setRecord(Map<String, T> record) {
      this.record = record;
   }

   @Override
   public String toString() {
      return super.toString();
   }
}

