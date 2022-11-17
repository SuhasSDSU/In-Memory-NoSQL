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


import edu.sdsu.db.Database;

import java.util.Arrays;
import java.util.Map;

public class Main {
   public static void main(String[] args) {
      Database db;
      db = new Database();
      db.put("Key1", 12);
      db.put("key2", "13");
      db.put("key3", new Integer[]{1,2,34});

      Map<String, Object> data = db.getCollection();
      data.forEach((key, value) -> System.out.println(key+":"+value));

      System.out.println(db.get("key2"));

   }
}