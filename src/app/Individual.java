
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

}
