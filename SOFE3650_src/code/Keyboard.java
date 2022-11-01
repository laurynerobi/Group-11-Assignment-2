import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard {
  public static void initKeyboard(JFrame frame) {
    frame.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
          if (Home.isHomeStarted()) {
            Home.end();
            Display.checkOut();
          } else {
            System.out.println("Refresh");
            Home.start();
            Display.start();
          }
        } else if (keyCode == KeyEvent.VK_X) {
          Home.remove();
          Display.remove();
          System.out.println("remove");
        } else {
          senditemCode(e.getKeyText(keyCode));
          System.out.println(e.getKeyText(keyCode));
        }
      }
    });
  }

  public static void senditemCode(String itemCode) {
    CashRegister.query(itemCode);
  }
}
