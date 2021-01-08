
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        int n = sc.nextInt();//size of the population
        int l = sc.nextInt();//chromosome length    
        double d;   

        /*DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00",unusualSymbols);*/

        Population p = new Population(n,l,generator);
        p.initPopulation();
        p.getPopulation();
            
        sc.close();
    }
}
