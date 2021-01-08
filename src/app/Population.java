import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Population {
    List<Individual> p = new ArrayList<>();
    int n,l;
    Random g;
    
    public Population(int n,int l, Random g){
        this.n=n;
        this.l=l;
        this.g=g;
    }

    public void initPopulation(){
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < l; j++)
                s.append(Math.round(g.nextDouble()));
            p.add(new Individual(s.toString()));
        }
    }

    public void getPopulation(){
        for (Individual individual : p) {
            System.out.println(individual.adn);
        }
    }


}
