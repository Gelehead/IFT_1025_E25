/**
 * Modèle de l'application. Cette classe permet de calculer la moyenne
 * des nombres entrés.
 */
public class Compteur {

    private int nbValeurs = 0;
    private double total = 0;

    public void ajouter(double nombre) {
        total += nombre;
        nbValeurs++;
    }

    public double getValeur() {
        if(nbValeurs == 0) {
            return 0;
        } else {
            return total / nbValeurs;
        }
    }
}
