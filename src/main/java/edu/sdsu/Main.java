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
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;
import edu.sdsu.db.Transaction;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();

      try{
         db.put("Arr", new ArrayType().fromString("[321,2,1]"));
         db.getArray("Arr").put( new ArrayType("Arr", db).fromString("[321,\"Testing\",1]"));
         db.getArray("Arr").put( new ObjectType().fromString("{ \"Name\" : \"Suhas\", \"Age\" : \"26\" }"));

         db.put("Object", new ObjectType().fromString("{ \"color\" : \"Black\", \"type\" : \"BMW\" }"));
         db.getObject("Object").put("NewObject", new ObjectType(db, "Object" ).fromString("{ \"color\" : \"Test\", \"type\" : \"Testing\" }"));
      }catch(Exception e){
         e.printStackTrace();
      }
      Map<String, Object> test = db.getCollection();
      test.forEach((k, v) -> System.out.println(k+"\t" + v));

      List<ICommand> commandsList = db.getCommandHistory();

      commandsList.forEach(e->System.out.println(e));
   }
}