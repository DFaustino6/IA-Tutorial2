
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        //int n = sc.nextInt();//size of the population
        //int l = sc.nextInt();//chromosome length    
        Population pop = new Population(generator);

        pop.addIndividual(new Individual(sc.nextLine()));
        pop.addIndividual(new Individual(sc.nextLine()));


        Population p2 = pop.uniformCrossover(pop.p.get(0),pop.p.get(1));
        
        p2.getPopulation();
        
        sc.close();
    }
}
