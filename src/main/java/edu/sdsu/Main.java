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
import edu.sdsu.db.Database;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();
      try{
         db.put("Key1", "null");
         db.put("Key2", new Integer(12));
         db.put("Key23", new Integer(12));
      }catch(Exception e){
         e.printStackTrace();
      }
      List<ICommand> tempCommands = db.getCommandHistory();


      db.remove("Key1");

      Map<String, Object> temp = db.getCollection();
      temp.forEach((key, value) -> System.out.println(key+":"+value));


      tempCommands = db.getCommandHistory();

      tempCommands.forEach((e) -> System.out.println(e) );

   }
}