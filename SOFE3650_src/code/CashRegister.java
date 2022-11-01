import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegister {
  public static void query(String itemCode) {
    List<String> productInfoList = new ArrayList<String>();
    String productName = "";
    String productPrice = "";
    Scanner scan = null;
    try {
      scan = new Scanner(new FileReader("products.txt")).useDelimiter("\\s");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String str;
    while (scan.hasNext()) {
      str = scan.next();

      productInfoList.add(str);
    }
    String[] productArray = productInfoList.toArray(new String[0]);
    for (int i = 0; i < productArray.length; i = i + 3) {
      if (productArray[i].equals(itemCode)) {
        productName = productArray[i + 1];
        productPrice = productArray[i + 2];
        break;
      }
    }
    Home.addProduct(productName, Double.parseDouble(productPrice));
    Display.displayProductInfo(productName, productPrice);
  }
}
