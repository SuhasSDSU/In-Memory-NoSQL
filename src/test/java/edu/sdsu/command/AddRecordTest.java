package edu.sdsu.command;

import edu.sdsu.db.Database;
import org.junit.jupiter.api.BeforeEach;

public class AddRecordTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      db.put("Key1", 12);
      db.put("key2", "13");
      db.put("key3", new Integer[]{1,2,34});
   }
}
