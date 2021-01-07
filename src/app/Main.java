
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        int n = sc.nextInt();//size of the population
        int l = sc.nextInt();//chromosome length    
        double d;   

        //DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        //unusualSymbols.setDecimalSeparator('.');
        //DecimalFormat df = new DecimalFormat("0.00",unusualSymbols);

        
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < l; j++){
                d = generator.nextDouble();       
                s.append(Math.round(d));
            }
           System.out.println(s);
        }

        sc.close();

    }
}
