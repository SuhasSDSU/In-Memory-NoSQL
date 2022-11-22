/*
 * http://www.eli.sdsu.edu/courses/fall22/cs635/assignments/Assignment3.pdf
 */
/*
* Need to Implement
* 1) Implement Pattern
* 2) Confirm doubts
* 3) Check the way data is to be displayed
* */
package edu.sdsu;


import edu.sdsu.commands.ICommand;
import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.IDataType;
import edu.sdsu.db.Database;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();
      try{
         db.put("Key23",  new ArrayType().fromString("[1,2,3,4]"));
      }catch(Exception e){
         e.printStackTrace();
      }
      List<ICommand> tempCommands;

      Map<String, Object> temp1 = db.getCollection();
      temp1.forEach((key, value) -> System.out.println("key:"+key+":\t"+"value:"+value));


      tempCommands = db.getCommandHistory();
      tempCommands.forEach(System.out::println);

   }
}