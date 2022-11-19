package edu.sdsu.dataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;

public class ArrayType{
   private Object value;

   public ArrayType(){

   }

   public ArrayType(Object value){
      this.value = value;
   }
   public String toString(){
      return Objects.toString(this.value);
   }

   public static Object fromString(Object value) throws Exception{
      ObjectMapper mapper = new ObjectMapper();
//      try {

      value = mapper.readValue((String) value, Object[].class);


//      } catch (JsonProcessingException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      } catch (IOException e) {
//         throw new RuntimeException(e);
//      }

      return value;
   }

}
