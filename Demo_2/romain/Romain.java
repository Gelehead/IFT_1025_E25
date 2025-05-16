package romain;

public class Romain {
    int chiffre;

    public Romain(int valeur) {
        this.chiffre = valeur;
    }

    public String repeter(int count, String string){
        String returnString = "";
        for (int i = 0; i < count; i++) {
            returnString += string;
        }

        return returnString;
    }

    public void ajouter( int x ){
        this.chiffre += x;
    }

    public void multiplier( int x ){
        this.chiffre *= x;
    }

    public String valeur() {
        String rom = "";

        // computeChiffre ici
        rom = computeChiffre(this.chiffre, 1000, "M", "?", "huh")
                + computeChiffre(this.chiffre, 100, "C", "D", "M")
                + computeChiffre(this.chiffre, 10, "X", "L", "C")
                + computeChiffre(this.chiffre, 1, "I", "V", "X");

        return rom;
    }


    public String computeChiffre(int n, int puiss10, String un, String cinq, String dix){
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

    public int toInt(){
        return this.chiffre;
    }
}
