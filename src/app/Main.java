
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", unusualSymbols);

        int n = sc.nextInt();//size of the population
        int l = sc.nextInt();//chromosome length  
          

        int s = sc.nextInt();

        double mProb = sc.nextDouble();
        double cProb = sc.nextDouble();
        
        int itr = sc.nextInt();
           
       
        AG ag = new AG(n, l, generator, cProb, mProb, itr);
        ag.GenerationOneMax();
       
        
        
        sc.close();
    }
}
