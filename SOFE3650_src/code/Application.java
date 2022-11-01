import javax.swing.*;

public class Application {
  private static void createAndShowGUI() {
    Display.createFrameStart();
    Display.createFrameScan();
    Display.createFrameCheckout();
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
