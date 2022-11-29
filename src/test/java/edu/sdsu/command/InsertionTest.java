package edu.sdsu.command;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try{
         db.put("Key1", 12);
         db.put("key2", "13");
         db.put("Array1", new ArrayType().fromString("[1,2,3.0,6]"));
         db.put("Object", new ObjectType().fromString("{ \"Name\" : \"Suhas\", \"Age\" : \"26\" }"));
      } catch (Exception e){
         e.printStackTrace();
      }
   }

   @DisplayName("Check the database to see if we get Array")
   @Test()
   public void checkIfArray(){
      String expected = "class edu.sdsu.dataType.ArrayType";
      String actual = String.valueOf(db.getArray("Array1").getClass());
      assertEquals(expected, actual);
   }

   @DisplayName("Check the database to see if we get Object")
   @Test()
   public void checkIfObject(){
      String expected = "class edu.sdsu.dataType.ObjectType";
      String actual = String.valueOf(db.getObject("Object").getClass());
      assertEquals(expected, actual);
   }
}
