/**
 * Un Vecteur est un tableau de nombres de type 'double'.
 *
 * @author     Thomas Ring, matricule 20162157.
 * @since      1er juin 2025
 */

public class Vecteur {

    /**
     * Tableau contenant les éléments du vecteur.
     */
    private double[] elements;


    /**
     * Constructeur avec en paramètre un tableau d'éléments de type `double`.
     * @param elements     Tableau d'éléments de type `double`.
     */
    public Vecteur(double[] elements){
        this.elements = elements.clone();
    }


    /**
     * Mutateur pour un élément donné du Vecteur.
     * @param index      int : index de l'élément muté.
     * @param valeur     double : valeur à donner à l'élément muté.
     */
    public void setElement(int index, double valeur){
        this.elements[index] = valeur;
    }


    /**
     * Accesseur pour un élément donné du Vecteur.
     * @param index       int : index de l'élément accédé.
     * @return            double : valeur de l'élément accédé.
     */
    public double getElement(int index){
        return elements[index];
    }


    /**
     * Calcule le produit scalaire avec un autre vecteur.
     * @param v       Vecteur : la méthode fait le produit scalaire entre le
     *                vecteur sur lequel la méthode est appelée et ce vecteur.
     * @return        double : résultat du produit scalaire.
     */
    public double dotProduct(Vecteur v){
        if (v.elements.length != this.elements.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }

        int resultat = 0;
        for (int i = 0; i < v.elements.length; i++){
            resultat += this.elements[i] * v.elements[i];
        }

        return resultat;
    }


    /**
     * Retourne un string représentant les éléments du vecteur.
     * @return      String représentant les éléments du vecteur.
     */
    @Override
    public String toString(){

        String vecteurAffiche = "{";

        // Ajoute chaque élément du vecteur au string, avec une virgule s'il ne
        // s'agit pas du dernier élément du vecteur.
        for(int i = 0; i < elements.length; i++){
            vecteurAffiche += elements[i];

            if(i != elements.length - 1){
                vecteurAffiche += ", ";
            }
        }

        vecteurAffiche += "}";

        return vecteurAffiche;
    }

    /**
     * Affiche le contenu du vecteur entres accolades sur la console.
     * Par exemple, le vecteur qui contient les nombres 1,2 et 3 sera affiché
     * avec : {1.0, 2.0, 3.0}
     */
    public void afficher(){
        System.out.println(this.toString());
    }
}