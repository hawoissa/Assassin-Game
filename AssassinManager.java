// Hawo Issa
// CSE 143 EG with Khushi Chaudhari
// Homework 3
// Assassin Manager is a class where people can play an 
// an online version of "Assassin." Each name on the list
// has a target which is the name right next to theirs. Their
// goal is to be the last assassin alive.

import java.util.*;
public class AssassinManager {
   
   private AssassinNode frontKillRing;
   private AssassinNode frontGraveYard;
   
   // pre: list must not be empty (throws IllegalArgumentException otherwise)
   // post: constructs a new assassin manager with the list of given people
   // param: List<String> names - given list of people
      public AssassinManager(List<String> names) {
      if (names == null) {
         throw new IllegalArgumentException();
      }
      for (int i = 0; i < names.size(); i++) {
         AssassinNode name = new AssassinNode(names.get(i));        
         if (frontKillRing == null) {
            frontKillRing = name;
         } else {
            AssassinNode current = frontKillRing;
            while (current.next != null) {
               current = current.next;    
            }
            current.next = name;         
         }  
      } 
   }
   
   // post: prints the name of the people in the kill ring
   //       and who they are stalking. If game is over, it 
   //       shows the winner stalking themself.
   public void printKillRing() {
      String spaces = "    ";
      AssassinNode current = frontKillRing;          
      while (current != null) {
         if (current.next != null) {
            System.out.println(spaces + current.name + " is stalking " + current.next.name);
         } else {
            System.out.println(spaces +  current.name + " is stalking " + frontKillRing.name);
         }
         current = current.next;
      }
   }
   
   // post: prints the name of the people in the graveyard
   //       and who they are killed by. If grave yard 
   //       empty, prints nothing. (most recent assasinated first)
   public void printGraveyard() {
      String spaces = "    ";
      AssassinNode current = frontGraveYard;
      while (current != null) {
         System.out.println(spaces + current.name + " was killed by " + current.killer);
         current = current.next;
      }
   }
   
   // post: returns true or false depending if the given name
   //       is in the kill ring 
   // param: String name - given name to check
   public boolean killRingContains(String name) {
      AssassinNode current = frontKillRing;
      while (current != null) {
         if ((current.name).equalsIgnoreCase(name)) {
            return true;
        }
        current = current.next;
      }
      return false;
   }
   
   // post: returns true or false depending if the given name 
   //       is in the grave yard
   // param: String name - given name to check
   public boolean graveyardContains(String name) {
      AssassinNode current = frontGraveYard;
      while (current != null) {
         if ((current.name).equalsIgnoreCase(name)) {
            return true;
         }
         current = current.next;
      }
      return false;  
   }
   
   // post: returns true or false depending if game is over
   public boolean gameOver() {
      return frontKillRing.next == null;
   }
   
   // post: returns the name of the winner
   public String winner() {
      if (!gameOver()) {
         return null;
      } else {
         return frontKillRing.name;
      }
   }
   
   // pre: game cannot be over (throws IllegalStateException otherwise) &
   //      given name must be in kill ring 
   //     (throws IllegalArgumentException otherwise)
   // post: this method records the assasination of a person, moves 
   //       their name to the front of the graveyard, and transfers
   //       the killer target to a new person 
   // param: String name - given name
   public void kill(String name) {
      if (gameOver()) {
         throw new IllegalStateException();
      } else if (!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      AssassinNode killed = frontKillRing;
      AssassinNode assassin = frontKillRing;
      if (killed.name.equalsIgnoreCase(name)) {        
         while (assassin.next != null) {
            assassin = assassin.next;
         }
         frontKillRing = frontKillRing.next;
         //killed.killer = assassin;                               
      } else {                      
         while (!assassin.next.name.equalsIgnoreCase(name)) {
            assassin = assassin.next; 
         }
         killed = assassin.next;
         assassin.next = killed.next;
         
      }       
         killed.killer = assassin.name;     
         killed.next = frontGraveYard; 
         frontGraveYard = killed;              
   }
   
}