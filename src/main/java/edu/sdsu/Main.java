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
import edu.sdsu.memento.DatabaseMemento;
import edu.sdsu.memento.Transaction;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();
      try{
         db.put("Arr2", new ArrayType().fromString("[321,2,1]"));
         db.getArray("Arr2").put( new ArrayType("Arr", db).fromString("[321,\"Testing\",1]"));
         db.getArray("Arr2").put( new ObjectType().fromString("{ \"Name\" : \"Suhas\", \"Age\" : \"26\" }"));

         db.put("Object2", new ObjectType().fromString("{ \"color\" : \"Black\", \"type\" : \"BMW\" }"));
         db.getObject("Object2").put("NewObject", new ObjectType(db, "Object" ).fromString("{ \"color\" : \"Test\", \"type\" : \"Testing\" }"));

         db.createSnapShot();
         db.put("1",1);
         db.put("2",2);
         db.put("3",3);
         db.put("4",4);
         db.createSnapShot();

         db.put("5",5);
         db.put("6",6);
         db.put("7",7);
         db.put("8",8);

      }catch(Exception e){
         e.printStackTrace();
      }

   }
}