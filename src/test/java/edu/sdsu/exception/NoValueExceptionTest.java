package edu.sdsu.exception;

import edu.sdsu.db.Database;
import edu.sdsu.exceptions.NoValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoValueExceptionTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      db.put("Key1", 12);
      db.put("key2", "13");
   }
   @DisplayName("No Value exception")
   @Test
   public void shouldThrowNoValue(){
      NoValueException exception = assertThrows(NoValueException.class, () -> {
         db.put("key", null);
      });

      String expected  = "class edu.sdsu.exceptions.NoValueException";
      assertEquals(expected, exception.getClass().toString());
   }
}
