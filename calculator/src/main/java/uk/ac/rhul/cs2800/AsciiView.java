package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Contains the menu based ASCII/text view.
 *
 * @author ZKAC176
 *
 */
public class AsciiView {
  private static CalcModel model;
  private static boolean running;
  private static boolean infix;
  private static boolean postfix;
  private static Scanner scanner;

  /**
   * Constructs AsciiView object.
   */
  public AsciiView() {
    model = new CalcModel();
    running = true;
    infix = false;
    postfix = false;
    scanner = new Scanner(System.in);
  }

  /**
   * Contains the main menu of the calculator. Presented as a simple text-based menu expecting user
   * input. Loops until the user inputs a certain character.
   */
  public void menu() {
    while (running == true) {
      System.out.println("--- Main Menu --- \nPlease select an option."
          + "\n1. Infix (Standard Notation) \n2. Postfix (Reverse Polish Notation"
          + "\n3. Q to exit the program");
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
            System.out.println("Result: " + model.evaluate(userInput, true));
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
            System.out.println("Result: " + model.evaluate(userInput, false));
          } catch (Exception e) {
            System.out.println("Invalid expression provided. Please try again.");
          }
        }
      } else if (userInput.equals("Q")) {
        System.out.println("Exited.");
        running = false;
      }
    }
  }
}
