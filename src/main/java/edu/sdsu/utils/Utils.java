package edu.sdsu.utils;

import edu.sdsu.commands.IDatabaseCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

      /**
       * Write to file.
       *
       * @param toSave the to save
       * @param filePath the file path
       * @param mode the mode
       */
      public static void writeToFile(Object toSave, String filePath, boolean mode) {
         FileOutputStream fileStream;
         try {
            File file = new File(filePath);
            fileStream = new FileOutputStream(file, mode);
            ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
            objStream.writeObject(toSave);
            objStream.close();
            fileStream.close();
         } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
         }  catch (IOException e) {
            throw new RuntimeException(e);
         }
      }

      /**
       * Read object from file.
       *
       * @param filePath the file path
       * @return the object
       */
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

      /**
       * Read objects from file.
       *
       * @param filePath the file path
       * @return the list
       */
      public static List<IDatabaseCommand> readObjectsFromFile(String filePath) {
         List<IDatabaseCommand> commands = new ArrayList<>();
         FileInputStream fileIn = null;
         try {
            fileIn = new FileInputStream(filePath);
            while (true) {
               ObjectInputStream input = new ObjectInputStream(fileIn);
               commands.add((IDatabaseCommand) input.readObject());
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

      /**
       * Delete.
       *
       * @param filePath the file path
       */
      public static void delete(String filePath) {
         new File(filePath).delete();
      }

   }
