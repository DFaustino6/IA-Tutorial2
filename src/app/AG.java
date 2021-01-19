import java.util.Random;

public class AG {
    private Population pop;
    Random r;
    int n,l,itr;
    double mProb,cProb;
    public AG(int n,int l,Random r,double cProb,double mProb,int itr){
        pop = new Population(n,l,r);
        this.r=r;
        this.n=n;
        this.l=l;
        this.cProb=cProb;
        this.mProb=mProb;
        this.itr=itr;
    }

    public void GenerationOneMax(){
        for (int j = 0; j < itr; j++) {
            System.out.println(j+": " + df.format(pop.maxFitness()) + " " + df.format(pop.averageFitness()) + " " + df.format(pop.minFitness()))
            pop = pop.GenOnemax(s, mProb, cProb);
        }
        System.out.println(itr+": " + df.format(pop.maxFitness()) + " " + df.format(pop.averageFitness()) + " " + df.format(pop.minFitness()));
    }
    
}
