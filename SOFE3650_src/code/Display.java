import javax.swing.*;

public class Display {
  static JFrame frameStart = new JFrame("StartHome");
  static JFrame frameScan = new JFrame("Scan");
  static JFrame frameCheckout = new JFrame("Checkout");
  static JLabel labelTotal = new JLabel("Your Total is ");
  static JLabel labelAmount = new JLabel();
  static int defaultHeight = 400;
  static int defaultWidth = 400;
  static DefaultListModel<String> display = new DefaultListModel<>();

  public static void createFrameScan() {
    JLabel label = new JLabel(
        "<html>Scan items<br><font color=red>or press enter</font></html>");
    frameScan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameScan.setVisible(false);
    frameScan.setLayout(null);
    frameScan.setSize(defaultHeight, defaultWidth);
    JList<String> list = new JList<>(display);
    list.setBounds(10, 40, 400, 200);
    label.setBounds(10, 0, 400, 30);
    labelTotal.setBounds(10, 250, 400, 30);
    frameScan.add(list);
    frameScan.add(label);
    frameScan.add(labelTotal);
    Keyboard.initKeyboard(frameScan);
  }

  public static void createFrameCheckout() {
    frameCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameCheckout.setVisible(false);
    frameCheckout.setLayout(null);
    frameCheckout.setSize(defaultHeight, defaultWidth);
    JLabel label = new JLabel("<html><font size=33>Checkout</font><br><br>Proceed to payment</html>");
    label.setBounds(100, 10, 400, 200);
    labelAmount.setBounds(100, 150, 400, 200);
    frameCheckout.add(label);
    frameCheckout.add(labelAmount);
  }

  public static void addToDisplay(String item) {
    labelTotal.setText("Total: $" + Home.total());
    display.addElement(item);
  }

  public static void remove() {
    labelTotal.setText("Total: $" + Home.total());
    display.remove(display.size() - 1);
  }

  public static void createFrameStart() {
    frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("<html><font size=33>CashRegister</font></html>");
    JLabel labelInstruction = new JLabel("Press enter");
    frameStart.setLayout(null);
    label.setBounds(50, 0, 400, 100);
    labelInstruction.setBounds(50, 140, 300, 200);
    frameStart.add(label);
    frameStart.add(labelInstruction);
    frameStart.setSize(defaultHeight, defaultWidth);
    frameStart.setVisible(true);
    Keyboard.initKeyboard(frameStart);
  }

  public static void checkOut() {
    hideAllFrames();
    labelAmount.setText("Total amount: $" + Home.total());
    frameCheckout.setVisible(true);
  }

  public static void start() {
    hideAllFrames();
    frameScan.setVisible(true);
    frameScan.requestFocus();
  }

  public static void hideAllFrames() {
    frameStart.setVisible(false);
    frameScan.setVisible(false);
    frameCheckout.setVisible(false);
  }

  public static void displayProductInfo(String productName, String productPrice) {
    addToDisplay(productName + "        " + productPrice);
    System.out.println("Product Name: " + productName + "\nProduct Price: " + productPrice);
  }
}
