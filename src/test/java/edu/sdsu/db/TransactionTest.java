package edu.sdsu.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.sdsu.commands.Transaction;
import edu.sdsu.dataType.ArrayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      db.put("Test", "Testing");
   }

   @DisplayName("Check if Transaction commits the data")
   @Test
   public void checkCommit(){
      Transaction test = db.getTransaction();
      test.put("Test", "Testing2");
      try {
         test.put("Test1", new ArrayType().fromString("[1,2,3]"));
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }
      test.commit();
      assertEquals(2, db.getDataSize());
   }

   @DisplayName("check the exceptions that would be caused by abort and contents")
   @Test
   public void checkAbort(){

   }
}
