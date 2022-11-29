package edu.sdsu.db;

import edu.sdsu.cursor.Cursor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursorTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      db.put("key3", 13);
   }
   @DisplayName("Check the value using cursor")
   @Test
   public void checkCursorContents(){
      Cursor cursor = db.getCursor("key3");
      assertEquals(13,cursor.value());
      db.put("key3", "Test");
      assertEquals("Test", cursor.value());
   }
}
