import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Population {
    public static final int HEAD = 0;
    public static final int TAIL = 1;

    public List<Individual> p;
    int n,l;
    Random g;

    public Population(int n,int l, Random g){
        p = new ArrayList<>(n);
        this.n=n;
        this.l=l;
        this.g=g;
        initPopulation();
    }

    public Population(int n,int l, Random g,List<Double> fit){
        p = new ArrayList<>(n);
        
        this.n=n;
        this.l=l;
        this.g=g;
        initPopulation(fit);
    }

    public Population(Random g){
        p = new ArrayList<>(n);
        this.g=g;
    }

    public Population(Population src){
        p = cloneList(src.p);
        g = src.g;
    }

    private List<Individual> cloneList(List<Individual> src){
        List<Individual> temp = new ArrayList<>();
        for (Individual individual : src) 
            temp.add(individual);
        
        return temp;
    }

    @Override
    public Object clone(){
        return new Population(this);
    }

    public void addIndividual(Individual i){
        p.add(i);
    }

    public void initPopulation(){
        for (int i = 0; i < n; i++) 
            p.add(new Individual(l,g));
    }

    public void initPopulation(List<Double> fit){
        for (int i = 0; i < n; i++) 
            p.add(new Individual(l,g,fit.get(i)));
    }

    public void getPopulation(){
        for (Individual individual : p) 
            System.out.println(individual.adn);
    }

    public List<Individual> tournament(){
        List<Individual>  fitest = new ArrayList<>();

        for (int i = 0; i < n; i++)
            fitest.add( p.get( randomIndividual( g.nextDouble(),0,n)).fitest( p.get(randomIndividual( g.nextDouble(),0,n) ) ) );

        return fitest;
    }

    public Population roulette(){
        Population p2 = new Population(g);
        double fitSum = fitnessSum();

        descendingFitness();
        probabilities(fitSum);

        int i = 0;

        while(i < p.size()){
            double r = g.nextDouble();
            for (Individual individual : p) {
                if(   r < individual.getProbability() ){
                    p2.addIndividual(individual);
                    break; 
                }
            } 
            i++; 
        }

        p2.ascendingADN();
        return p2;
    }

    public Population sus(){
        Population keep = new Population(g);
        List<Double> points = new ArrayList<>();

        double fitSum = fitnessSum();
        double d = fitSum/p.size();
        double r = g.nextDouble() * d;

        for (int i = 0; i < p.size(); i++)  
            points.add( r + (i * d));

        return susRWS(keep, points);
    }

    private Population susRWS(Population keep,List<Double> points){

        for (Double point : points) {
            int i = 0;
            double fitSumUntil = p.get(i).fitness;
            
            while (fitSumUntil < point) {                      
                i++; 
                fitSumUntil += p.get(i).fitness;            
            }

            keep.addIndividual(p.get(i));
        }
        return keep;
    }

    public Population onePointCrossover(Individual parent,Individual parent2){
        Population p2 = new Population(g);

        int r = randomIndividual(g.nextDouble(),1,parent.adn.length()-1);
       
        String firstParent = parent.adn.substring(0,r);
        String firstParent2 = parent.adn.substring(r,parent.adn.length());
        String secondParent = parent2.adn.substring(0,r);
        String secondParent2 = parent2.adn.substring(r,parent2.adn.length());

        StringBuilder child1 = new StringBuilder();
        child1.append(firstParent);
        child1.append(secondParent2);
        
        p2.addIndividual(new Individual(child1.toString()));

        StringBuilder child2 = new StringBuilder();
        child2.append(secondParent);
        child2.append(firstParent2);
        p2.addIndividual(new Individual(child2.toString()));

        return p2;      
    }

    public Population uniformCrossover(Individual parent,Individual parent2) {
        Population p2 = new Population(g); 
        StringBuilder child = new StringBuilder();
        StringBuilder child2 = new StringBuilder();

        for (int j = 0; j < parent.adn.length(); j++) {
            int r = (int) Math.round(g.nextDouble());
        
            if(r == HEAD){
                child.append(parent2.adn.charAt(j));
                child2.append(parent.adn.charAt(j));
            }                
            else if(r == TAIL){
                child.append(parent.adn.charAt(j));  
                child2.append(parent2.adn.charAt(j));
            }        
        }
       
        p2.addIndividual(new Individual(child.toString()));
        p2.addIndividual(new Individual(child2.toString()));

        return p2;
    }
    
    public Individual bitFlipMutation(Individual parent,double prob){
        StringBuilder child = new StringBuilder();

        for (int i = 0; i < parent.adn.length(); i++) {
            double r =  g.nextDouble();
            char c = parent.adn.charAt(i);

            if(r < prob){
                if(c == '1')  child.append(0);
                else if(c == '0') child.append(1);
            }    
            else child.append(c);
        }

        return new Individual(child.toString());
    }

    public List<Integer> randomPermutation(int size){
        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < size; i++) 
            v.add(i);

        for (int i = 0; i < size-1; i++) {
            int r = randomIndividual(g.nextDouble(), i, size-1);
            exchangePositions(v, i, r);
        }

        return v;
    }

    public Population tournamentSWR(int size){
        Population p2 = new Population(g);
        for (int i = 0; i < size; i++) {
            Population temp =(Population) this.clone();

            temp.populationPermutation();

            for (int j = 0; j < p.size()/size; j++) {
                List<Individual> subPop = temp.p.subList(j*size, (j+1)*size);
                Individual fitest = subPop.get(0);
                
                for (int k = 1; k < subPop.size(); k++) 
                    fitest = fitest.fitest(subPop.get(k));
                
                p2.addIndividual(fitest);
            }
        }
        return p2;
    }

    public Population GenOnemax(int s, double mProb, double cProb){
        Population p2 = new Population(g);

        p2 = tournamentSWR(s);
 
        Population temp = new Population(g);
        for (int i = 0; i < n; i+=2){
            double r =g.nextDouble();
            
            if( r < cProb){
                temp=onePointCrossover(p2.p.get(i), p2.p.get(i+1));
                p2.p.set(i, temp.p.get(0));
                p2.p.set(i+1, temp.p.get(1));
            }
        }
        
        for (int i = 0; i < n; i++) 
            p2.p.set(i,bitFlipMutation(p2.p.get(i), mProb));
            
        return p2;
    }

    public double maxFitness(){
        Individual fitest= p.get(0);

        for (int i = 1; i < p.size(); i++) 
            if(fitest.fitness<p.get(i).fitness) fitest = p.get(i);
     
        return fitest.fitness;

    }
    
    public double minFitness(){
        Individual fitest= p.get(0);

        for (int i = 1; i < p.size(); i++) 
            if(fitest.fitness>p.get(i).fitness) fitest = p.get(i);
     
        return fitest.fitness;

    }

    public double averageFitness(){   
        return fitnessSum()/p.size();

    }

    private void populationPermutation(){
        List<Integer> v = randomPermutation(p.size());
        List<Individual> ind= new ArrayList<>();
        
        int j=0;
        for (Integer i : v) 
            ind.add(p.get(i));

        p=ind;
    }

    private void exchangePositions(List<Integer> v, int i, int r) {
        int temp = v.get(i);
        v.set(i, v.get(r));
        v.set(r, temp);
    }

    private int randomIndividual(double u,int a,int b){     
        return (int) ( a + Math.round( u * ( b - a ) ) );
    }

    private double fitnessSum(){
        double sFit=0.0;

        for (Individual individual : p) 
            sFit+=individual.fitness; 

        return sFit;
    }

    private void probabilities(double fitSum){
        double previousProb = 0.0;

        if(fitSum>0)
            for (Individual individual : p){
                individual.setProbability( previousProb + ( individual.fitness / fitSum ));
                previousProb = individual.getProbability();
            }
    }

    private void ascendingADN(){
        p.sort((Individual o1,Individual o2)-> o1.adn.compareTo(o2.adn));
    }

    private void descendingFitness(){
        p.sort((Individual o1,Individual o2)-> Double.compare(o2.fitness, o1.fitness));
    }

    
}
