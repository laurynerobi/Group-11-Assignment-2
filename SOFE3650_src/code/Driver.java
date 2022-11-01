import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    boolean run = true;
    while (run) {
      System.out.print("Input new product or press 'x' ");
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      if (input.equalsIgnoreCase("x"))
        run = false;
      else
        Keyboard.senditemCode(input);
    }
  }
}
