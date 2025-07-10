
/**
 * Modèle de l'application. Le modèle peut comporter plusieurs classes
 * au besoin, le modèle de cette application est cependant très simple
 * et est contenu dans une seule, toute petite classe.
 *
 * Permet d'additionner des nombres réels
 */
public class Compteur {

    private double valeur = 0;

    public void ajouter(double nombre) {
        valeur += nombre;
    }

    public double getValeur() {
        return valeur;
    }
}
