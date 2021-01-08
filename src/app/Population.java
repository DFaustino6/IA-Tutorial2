import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Population {
    List<Individual> p;
    int n,l;
    Random g;

    public Population(int n,int l, Random g){
        p = new ArrayList<>(n);
        this.n=n;
        this.l=l;
        this.g=g;
    }

    public void initPopulation(){
        for (int i = 0; i < n; i++) 
            p.add(new Individual(l,g));
    }

    public void getPopulation(){
        for (Individual individual : p) 
            System.out.println(individual.adn);
    }


}
