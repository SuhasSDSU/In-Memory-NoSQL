package edu.sdsu.exception;

import edu.sdsu.db.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoValueExceptionTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
//      db.put("Key1", 12);
//      db.put("key2", "13");
   }
   @DisplayName("No Value exception")
   @Test
   public void shouldThrowNoValue(){
      try{
         db.put("key3", null);
      }
      catch (Exception e){
         e.printStackTrace();
      }

   }
}
