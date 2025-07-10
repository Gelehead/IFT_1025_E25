
/**
 * Modèle de l'application. Le modèle peut comporter plusieurs classes
 * au besoin, le modèle de cette application est cependant très simple
 * et est contenu dans une seule, toute petite classe.
 *
 * Permet d'additionner des nombres réels.
 *
 * Notez que cette classe est exactement la même que dans le premier
 * exemple (programme MVC1)
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
