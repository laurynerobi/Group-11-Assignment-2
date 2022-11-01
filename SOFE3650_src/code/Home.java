import java.util.ArrayList;

public class Home {
  static double calculate = 0;
  static ArrayList<String> checkout = new ArrayList<String>();
  static ArrayList<Double> price = new ArrayList<Double>();
  static boolean started = false;

  public static Boolean isHomeStarted() {
    return started;
  }

  public static void addProduct(String productName, double productPrice) {
    checkout.add(productName);
    price.add(productPrice);
    calculate += productPrice;
  }

  public static void remove() {
    int size = checkout.size();
    checkout.remove(size - 1);
    int last = price.size();
    double rm = price.get(last - 1);
    price.remove(last - 1);
    calculate = rm - 1;
  }

  public static double total() {
    double rounded = Math.round(calculate * 100.0) / 100.0;
    return rounded;
  }

  public static void start() {
    checkout.clear();
    started = true;
  }

  public static void end() {
    started = false;
  }
}
