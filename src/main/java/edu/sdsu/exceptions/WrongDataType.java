package edu.sdsu.exceptions;

public class WrongDataType extends ClassCastException{
   public WrongDataType(String message){
      super(message);
   }
}
