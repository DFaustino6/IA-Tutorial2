
public class Individual {
    String adn;

    public Individual(String s){
        adn=s;
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
        for (int i = adn.length()-1; i > -1; i--) {

            d += Character.getNumericValue(adn.charAt(i)) * Math.pow(2, pow++);
        }
        return (int) Math.pow(d, 2);
    }

}
