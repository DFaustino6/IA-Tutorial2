
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        //int n = sc.nextInt();//size of the population
        //int l = sc.nextInt();//chromosome length    
        Population pop = new Population(generator);
        
        double prob = sc.nextDouble();

        Individual ind = pop.bitFlipMutation(new Individual(sc.next()),prob);
        
        System.out.println(ind);
        
        sc.close();
    }
}
