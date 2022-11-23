package edu.sdsu.command;

import edu.sdsu.db.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletionTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try{
//         db.put("Key1", 12);
//         db.put("key2", "13");
//         db.put("key3", new Integer[]{1,2,34});
      } catch (Exception e){
         e.printStackTrace();
      }
   }

   @DisplayName("Check the value using key")
   @Test
   public void checkDelete(){
      db.remove("Key1");
   }
}
