package edu.sdsu.db;


import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try {
         db.put("key3", new Integer(13));
         db.put("Array", new ArrayType().fromString("[321,2,1]"));
         db.getArray("Array").put( new ArrayType("Array", db).fromString("[321,\"Testing\",1]"));
         db.put("Object", new ObjectType().fromString("{ \"color\" : \"Black\", \"Make\" : \"BMW\" }"));
      }catch (Exception e){
         e.printStackTrace();
      }
   }
   @DisplayName("Test the contents of Db")
   @Test
   public void getDatabaseSize(){
      assertEquals(3, db.getDataSize());
   }

   @DisplayName("Test database SnapShot creation")
   @Test
   public void checkDatabaseSnapShot(){
      db.createSnapShot();
      String filePath = Constants.DATABASE_FILE_PATH;
      File file = new File(filePath);
      // checking if the snapshot creates file
      assertEquals(Boolean.TRUE,file.exists());
   }

   @DisplayName("Test Command SnapShot creation")
   @Test
   public void checkCommandSnapShot(){
      init();
      db.recover();
      String filePath = Constants.COMMAND_FILE_PATH;
      File file = new File(filePath);
      assertEquals(Boolean.TRUE, file.exists());
   }
}
