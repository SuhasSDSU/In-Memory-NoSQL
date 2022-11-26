package edu.sdsu.utils;

import edu.sdsu.commands.ICommand;
import edu.sdsu.db.Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
   public static void writeToFile(Database toSave, String filePath, boolean mode) {

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
   }// writeToFile

   public static Object readObjectFromFile(String filePath) {
      Object object = null;
      try {
         File mementoFile = new File(filePath);
         if (mementoFile.exists()) {
            FileInputStream fileStream = new FileInputStream(mementoFile);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            object = objStream.readObject();
            System.out.println(object);
            objStream.close();
            fileStream.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      return object;
   }
   public static List<ICommand> readObjectsFromFile(String filePath) {
      List<ICommand> commands = new ArrayList<>();
      FileInputStream fileIn = null;
      try {
         fileIn = new FileInputStream(filePath);
         while (true) {
            ObjectInputStream input = new ObjectInputStream(fileIn);
            commands.add((ICommand)input.readObject());
         }
      } catch (EOFException e) {
         try {
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return commands;
   }

   public static void delete(String filePath) {
      new File(filePath).delete();
   }

}
