package edu.sdsu.db;

public interface IDatabase<T extends Object> {
   void put(String key, T value);
}
