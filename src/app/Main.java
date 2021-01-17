
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        //int n = sc.nextInt();//size of the population
        //int l = sc.nextInt();//chromosome length    
        Population p = new Population(generator);

        while(sc.hasNext())
            p.addIndividual(new Individual(sc.next(),sc.nextDouble()));


        Population p2 = p.sus();
        
        p2.getPopulation();
        
        sc.close();
    }
}
