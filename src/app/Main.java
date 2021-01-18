
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        //int n = sc.nextInt();//size of the population
        //int l = sc.nextInt();//chromosome length  
        Population pop = new Population(generator);  

        int n = sc.nextInt();

        while (sc.hasNext()) 
            pop.addIndividual(new Individual(sc.next(),sc.nextDouble())); 
        
        Population p2= pop.tournamentSWR(n);

        p2.getPopulation();
        
        
        sc.close();
    }
}
