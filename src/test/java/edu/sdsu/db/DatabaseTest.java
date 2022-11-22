package edu.sdsu.db;


import edu.sdsu.dataType.ArrayType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try {
         db.put("key3", new Integer(13));
         db.put("Array1", new ArrayType().fromString("[1,2,3.0,6]"));
      }catch (Exception e){
         e.printStackTrace();
      }
   }
   @DisplayName("Test the contents of Db")
   @Test
   public void displayData(){
      Map<String, Object> data = db.getCollection();
      data.forEach((key, value) -> System.out.println(key+":"+value.getClass()));
   }


}
