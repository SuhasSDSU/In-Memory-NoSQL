package edu.sdsu.db;
import java.util.Date;
import java.util.HashMap;

public class Record {
   private String rowId;
   private HashMap<String, String> columnValuesMap;
   private Date createdAt;
   private Date UpdatedAt;

   public Record(String rowId, HashMap<String, String> columnsMap, Date createdAt, Date updatedAt) {
      this.rowId = rowId;
      this.columnValuesMap = columnsMap;
      this.createdAt = createdAt;
      UpdatedAt = updatedAt;
   }

   public HashMap<String, String> getColumnValuesMap() {
      return columnValuesMap;
   }

   public void setColumnValuesMap(HashMap<String, String> columnValuesMap) {
      this.columnValuesMap = columnValuesMap;
   }

   public String getRowId() {
      return rowId;
   }

   public void setRowId(String rowId) {
      this.rowId = rowId;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public Date getUpdatedAt() {
      return UpdatedAt;
   }

   public void setUpdatedAt(Date updatedAt) {
      UpdatedAt = updatedAt;
   }
}

