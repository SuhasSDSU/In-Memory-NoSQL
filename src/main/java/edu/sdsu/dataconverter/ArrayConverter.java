package edu.sdsu.dataconverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdsu.dataType.IDataType;

import java.io.IOException;

public class ArrayConverter implements IConverter{
   @Override
   public IDataType convert(Object value) {
      ObjectMapper mapper = new ObjectMapper();
      try {
         value = mapper.readValue((JsonParser) value, Object[].class);
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return (IDataType) value;
   }

}
