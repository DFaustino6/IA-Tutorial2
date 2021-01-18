
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
        Population pop = new Population(n,l,generator);  

        int s = sc.nextInt();

        double mProb = sc.nextDouble();
        double cProb = sc.nextDouble();
        
        Population p2= pop.GenOnemax(s,mProb,cProb);
        System.out.println("0: " + df.format(pop.maxFitness()) + " " + df.format(pop.averageFitness()) + " " + df.format(pop.minFitness()));
        System.out.println("1: " + df.format(p2.maxFitness()) + " " + df.format(p2.averageFitness()) + " " + df.format(p2.minFitness()));
        
        
        sc.close();
    }
}
