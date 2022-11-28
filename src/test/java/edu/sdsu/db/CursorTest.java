package edu.sdsu.db;

import edu.sdsu.dataType.ArrayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursorTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try {
         db.put("key3", new Integer(13));
         db.put("Arr2", new ArrayType().fromString("[321,2,1]"));
         db.getArray("Arr2").put( new ArrayType("Arr", db).fromString("[321,\"Testing\",1]"));
      }catch (Exception e){
         e.printStackTrace();
      }
   }
   @DisplayName("Test the Check the value using cursor")
   @Test
   public void displayData(){
      assertEquals(3, db.getDataSize());
   }
}
