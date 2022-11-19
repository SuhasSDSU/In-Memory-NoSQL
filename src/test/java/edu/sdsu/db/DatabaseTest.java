package edu.sdsu.db;


import edu.sdsu.dataType.IDataType;
import edu.sdsu.dataType.IntegerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.util.Map;

public class DatabaseTest {
   Database db;
   @BeforeEach
   public void init(){
      db = new Database();
      try {
//         db.put("Key1", new 12);
//         db.put("key2", "13");
         db.put("key3", new IntegerType(13));
      }catch (Exception e){
         e.printStackTrace();
      }
   }
   @DisplayName("Test the contents of Db")
   @Test
   public void displayData(){
      Map<String, Object> data = db.getCollection();
//      Map<String, IDataType> data = db.getCollection();
      data.forEach((key, value) -> System.out.println(key+":"+value));
   }

}
