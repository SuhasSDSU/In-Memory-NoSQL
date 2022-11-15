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
import edu.sdsu.db.Table;
import java.util.Map;

public class Main {
   public static void main(String[] args) {
      Table table = new Table();
      table.add("1","Testing1");
      table.add("2","Testing2");
      table.add("3","Testing3");
      table.add("4","Testing4");
      table.add("5","Testing5");
      table.add("6","Testing6");

      Map<String, Map> records = table.getCollections();
      records.forEach((key, value) -> System.out.println(key + ":" + value));
   }
}