/***
 * @Author: Suhas Pindiproli
 * REDID: 824816168
 * Assignment-3 : Implement In-Memory Database using Design Patterns
 */

package edu.sdsu;

import edu.sdsu.dataType.ArrayType;
import edu.sdsu.dataType.ObjectType;
import edu.sdsu.db.Database;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();
      try{
         db.put("Arr2", new ArrayType().fromString("[321,2,1]"));
         db.getArray("Arr2").put( new ArrayType("Arr", db).fromString("[321,\"Testing\",1]"));
         db.getArray("Arr2").put( new ObjectType().fromString("{ \"Name\" : \"Suhas\", \"Age\" : \"26\" }"));
         db.put("Object2", new ObjectType().fromString("{ \"color\" : \"Black\", \"type\" : \"BMW\" }"));
         db.getObject("Object2").put("NewObject", new ObjectType(db, "Object2").fromString("{ \"color\" : \"Test\", \"type\" : \"Testing\" }"));
         db.put("1",1);
         db.put("2",2);
         db.put("3",3);
         db.put("4",4);
         db.put("5",5);
         db.put("6",6);
         db.put("7",7);
         db.put("9",8);
         db.put("10",8);
         db.put("5",10);
         db.recover();

      }catch(Exception e){
         e.printStackTrace();
      }

   }
}