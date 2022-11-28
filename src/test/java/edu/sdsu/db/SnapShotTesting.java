package edu.sdsu.db;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapShotTesting {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try{
         db.put("Key1", 12);
         db.put("key2", "13");
         db.put("Array1", new ArrayType().fromString("[1,2,3.0,6]"));
      } catch (Exception e){
         e.printStackTrace();
      }
   }
   @DisplayName("Testing working of Snapshot")
   @Test
   public void checkSnapShotFile(){
      String commandSnapShotFile = Constants.COMMAND_FILE_PATH;
      String databaseSnapShotFile = Constants.DATABASE_FILE_PATH;
      db.createSnapShot();
      assert(new File(commandSnapShotFile).exists());
      assert(new File(databaseSnapShotFile).exists());
   }
}
