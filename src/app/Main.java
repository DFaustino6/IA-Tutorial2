
import java.text.*;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        Random generator = new Random(0); 
        Scanner sc = new Scanner(System.in);    

        int n = sc.nextInt();//size of the population
        int l = sc.nextInt();//chromosome length    

        List<Double> fitness = new ArrayList<>();
        
        for (int i = 0; i < n; i++) 
            fitness.add(sc.nextDouble());
        

        Population p = new Population(n, l, generator);
        

        sc.close();
    }
}
