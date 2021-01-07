
package app;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String args[]) {
       Random generator = new Random(0); 
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       double d;

       DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
       unusualSymbols.setDecimalSeparators('.');
       DecimalFormat df = new DecimalFormat("0.00",unusualSymbols);

       for (int i = 0; i < args.length; i++) {
           d = generator.nextDouble();
           System.out.println(df.format(d));
       }

       sc.close();

    }
}
