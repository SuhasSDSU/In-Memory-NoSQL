package edu.sdsu.utils;

import edu.sdsu.db.Database;

import java.io.*;
import java.util.Map;

public class Utils {
   public static void storeDatabaseInFile(Database toSave, String filePath, boolean mode) {

      BufferedWriter bufferedWriter;
      try {
         File file = new File(filePath);
         if (!file.exists()) file.createNewFile();
         bufferedWriter = new BufferedWriter(new FileWriter(filePath));
         for (Map.Entry<String, Object> entry :
               toSave.getCollection().entrySet()) {

            // put key and value separated by a colon
            bufferedWriter.write(entry.getKey() + ":"
                  + entry.getValue());

            // new line
            bufferedWriter.newLine();
         }
         bufferedWriter.flush();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }// storeDatabaseInFile

   public static void storeCommandsInFile(Database toSave, String filePath, boolean mode) {

      BufferedWriter bufferedWriter;
      try {
         File file = new File(filePath);
         if (!file.exists()) file.createNewFile();
         bufferedWriter = new BufferedWriter(new FileWriter(filePath));
         toSave.getCommandHistory().forEach(command ->
         {
            try {
               bufferedWriter.write(command.toString());
               bufferedWriter.newLine();
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         });
         bufferedWriter.flush();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }// storeCommandsInFile

   public static Object readFromFile(String filePath) {
      BufferedReader bufferedReader;
      try {
         bufferedReader = new BufferedReader(new FileReader(filePath));
         File mementoFile = new File(filePath);
         if (mementoFile.exists()) {
            String st;
            while ((st = bufferedReader.readLine()) != null){
               System.out.println(st);
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      return "Reading from file completed";
   }

   public static void delete(String filePath) {
      new File(filePath).delete();
   }

}
