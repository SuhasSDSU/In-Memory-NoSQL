package edu.sdsu.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.sdsu.dataType.ArrayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
      Transaction dbTransaction = db.getTransaction();
      dbTransaction.put("Test", "Testing2");
      try {
         dbTransaction.put("Test1", new ArrayType().fromString("[1,2,3]"));
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }
      dbTransaction.commit();
      assertEquals(2, db.getDataSize());
   }

   @DisplayName("check the exceptions that would be caused by abort and contents")
   @Test
   public void checkAbort(){
      Transaction transaction = db.getTransaction();
      UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
         transaction.put("String", "Test");
         transaction.abort();
         transaction.put("Test", "Value");
      });

      assertEquals(2, db.getDataSize());
      String expected  = "class java.lang.UnsupportedOperationException";
      assertEquals(expected, exception.getClass().toString());
   }
}
