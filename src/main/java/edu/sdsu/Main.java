/*
 * http://www.eli.sdsu.edu/courses/fall22/cs635/assignments/Assignment3.pdf
 */

package edu.sdsu;

import edu.sdsu.db.Collection;
import edu.sdsu.db.Database;
import edu.sdsu.db.Manager;

import java.util.HashMap;

public class Main {
   public static void main(String[] args) {

      Manager object = new Manager();
      object.createDatabase("Test1");
      Database database =  new Database("Test1DB");
      HashMap<String, Database> hashMap = new HashMap<>();
      hashMap.put("Test1", database);
      object.setDatabaseHashMap(hashMap);
   }
}