
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

        List<Integer> v = pop.randomPermutation(n);

        for (int i = 0; i < n; i++) {
            System.out.println(v.get(i));
        }
        
        
        sc.close();
    }
}
