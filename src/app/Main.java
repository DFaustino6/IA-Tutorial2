
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        //Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        //int n = sc.nextInt();//size of the population
        //int l = sc.nextInt();//chromosome length    
        //double d;   

        //DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        //unusualSymbols.setDecimalSeparator('.');
        //DecimalFormat df = new DecimalFormat("0.00",unusualSymbols);

        String s = sc.next();
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1') n++;
        }
        System.out.println(n);
        sc.close();

    }
}
