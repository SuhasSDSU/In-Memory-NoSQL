package edu.sdsu.db;
import java.util.Date;
import java.util.HashMap;

public class Collection {
   private String collectionName;
   private HashMap<String, Record> records;
   private Date createdAt;

   public Collection(String collectionName) {
      this.collectionName = collectionName;
      this.records = new HashMap<>();
      this.createdAt = new Date();
   }

   public void insertEntry(String rowId, HashMap<String, String> columnsMap) {
      if (records.containsKey(rowId)) {
         System.out.println("Duplicate primary key : " + " Insertion failed");
      } else {
         Record record =  new Record(rowId, columnsMap, new Date(), new Date());
         records.put(rowId, record);
         System.out.println("Successfully added a row");
      }
   }

   public void updateEntry(String rowId, HashMap<String, String>valuesMap) {
      Record record = records.get(rowId);
      valuesMap.forEach( (k, v) -> {
         record.getColumnValuesMap().put(k, v);
      });
      System.out.println("Row successfully updated");
      record.setUpdatedAt(new Date());
   }

   public String getCollectionName() {
      return collectionName;
   }

   public void setCollectionName(String collectionName) {
      this.collectionName = collectionName;
   }

   public HashMap<String, Record> getRecords() {
      return records;
   }

   public void setRecords(HashMap<String, Record> records) {
      this.records = records;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }
}
