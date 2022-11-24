package edu.sdsu.db;

public class Transaction {
   private boolean isAborted;
   public Transaction(){
      this.isAborted = false;
   }

   public boolean isAborted() {
      return isAborted;
   }

   public void setAborted(boolean aborted) {
      isAborted = aborted;
   }
}
