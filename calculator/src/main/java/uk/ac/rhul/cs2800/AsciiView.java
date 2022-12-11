package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class AsciiView {
  String expression;
  String answer;
  
  public static void menu() {
    RevPolishCalc rp = new RevPolishCalc();
    StandardCalc sc = new StandardCalc();
    boolean running = true;
    boolean infix = false;
    boolean postfix = false;
    Scanner scanner = new Scanner(System.in);
    
    while (running == true) {
      System.out.println("--- Main Menu --- \nPlease select an option."
          + "\n1. Infix (Standard Notation) \n2. Postfix (Reverse Polish Notation");
      String userInput = scanner.nextLine();
      // infix
      if (userInput.equals("1")) {
        infix = true;
        System.out.println(
            "--- Infix Notation Calculator ---" + "\nPlease enter a valid expression below."
                + "\nMake sure there is a space between each character."
                + "\nEnter Q to return to Main Menu.");
        while (infix) {
          userInput = scanner.nextLine();
          if (userInput.equals("Q")) {
            infix = false;
            break;
          }
          try {
            System.out.println("Result: " + sc.evaluate(userInput));
          } catch (Exception e) {
            System.out.println("Invalid expression provided. Please try again.");
          }
        }
        // postfix
      } else if (userInput.equals("2")) {
        postfix = true;
        System.out.println("--- Postfix Notation Calculator ---"
            + "\nPlease enter a valid reverse polish expression below."
            + "\nMake sure there is a space between each character."
            + "\nEnter Q to return to Main Menu.");
        while (postfix) {
          userInput = scanner.nextLine();
          if (userInput.equals("Q")) {
            postfix = false;
            break;
          }
          try {
            System.out.println("Result: " + rp.evaluate(userInput));
          } catch (Exception e) {
            System.out.println("Invalid expression provided. Please try again.");
          }
        }
      } else if (userInput.equals("Q")) {
        running = false;
      }
    }
  }

  public static void main(String[] args) {
    menu();
  }
}
