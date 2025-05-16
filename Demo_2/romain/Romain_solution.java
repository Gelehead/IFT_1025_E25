package romain;
public class Romain_solution {
    int value;

    public Romain_solution(int value){
        this.value = value;
    }

    public String repeter(int count, String string) {
        String result = "";
        for ( int i = 0 ; i < count ; i ++) {
            result += string;
        }
        return result;
    }

    public String valeur(){
        int n = this.value;

        String returnString = "";

        returnString = computeChiffre(n, 1000, "?", "!", "M")
                + computeChiffre(n, 100, "M", "D", "C")
                + computeChiffre(n, 10, "C", "L", "X")
                + computeChiffre(n, 1, "X", "V", "I");

        return returnString;
    }

    public String computeChiffre(int n, int puiss10, String dix, String cinq, String un){
        int c = (int) Math.floor(n / puiss10) % 10;

        if ( c < 4 ) {
            return repeter(c, un);
        } else if ( c == 4 ) {
            return "" + un + cinq;
        } else if ( c < 9 ) {
            return cinq + repeter(c - 5, un);
        } else {
            return "" + un + dix;
        }
    }

    public void multiplier(int n ) {
        this.value = this.value * n;
    }

    public void additioner(int n) {
        this.value = this.value + n;
    }
}