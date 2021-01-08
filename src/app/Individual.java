import java.util.Random;

public class Individual {
    String adn;

    public Individual(int l, Random g){
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < l; j++)
            s.append(Math.round(g.nextDouble()));
        adn=s.toString();
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

}
