import java.util.Random;

public class Individual {
    String adn;
    double fitness;
    private double probability;

    public Individual(int l, Random g){
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < l; j++)
            s.append(Math.round(g.nextDouble()));
        adn=s.toString();
        fitness = countAdn('1');
    }

    public Individual(String s){
        adn=s;
        fitness = countAdn('1');
    }

    public Individual(int l, Random g,double fitness){
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < l; j++)
            s.append(Math.round(g.nextDouble()));
        adn=s.toString();
        this.fitness=fitness;
    }

    public Individual(String s,double fitness){
        adn=s;
        this.fitness=fitness;
    }

    public int countAdn(char c){
        int n = 0;
        for (int i = 0; i < adn.length(); i++) 
            if(adn.charAt(i)==c) n++;
        return n;
    }

    public int binaryToDec(){
        int d = 0;
        int pow = 0;
        for (int i = adn.length()-1; i > -1; i--)
            d += Character.getNumericValue(adn.charAt(i)) * Math.pow(2, pow++);
        return d*d;
    }

    public Individual fitest(Individual second){
        if(fitness >= second.fitness) return this;
        else return second;
    }   

    public void setProbability(double probability){
        this.probability = probability;
    }

    public double getProbability(){
        return probability;
    }

    public int adnCmp(Individual i){
        return adn.compareTo(i.adn);
    }

    @Override
    public String toString(){
        return adn;
    }
}
