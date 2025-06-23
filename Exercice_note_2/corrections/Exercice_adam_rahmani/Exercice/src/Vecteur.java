/**
 * @author Adam Rahmani
 * @version exercice note 2
 * matricule: 20186680
 * Date : 2025-05-30
 *
 * Class Vecteur qui nous permet de faire des manipulations
 * dans le vecteur
 */

public class Vecteur {
    private double elements[];

    /**
     * Permet d'acceder au elements
     * @param elements tableau d'elements
     */
    public Vecteur(double[] elements){
        this.elements = elements;
    }

    /**
     * Permet de changer la valeur à l'index donné
     * @param index position dans le tableau de l'element a modifier
     * @param valeur nouvelle valeur
     */
    public void setElement(int index, double valeur){
    elements[index] = valeur;
    }

    /**
     * Permet de retourner la valeur a l'index demandé
     * @param index position dans le tableau
     * @return la valeur de l'element a l'index donne
     */
    public double getElement(int index){
        return elements[index];
    }

    /**
     * Permet de retourner la longueur des elements
     * @return la longueur des elements
     */
    public int length() {
        return elements.length;
    }

    /**
     *  Calcule le produit scalaire avec un autre vecteur
     * @param v vecteur
     * @return somme la somme du produit scalaire
     */
    public double dotProduct(Vecteur v){
        if (elements.length != v.length() ){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
            }
        double somme = 0;
        for (int i = 0; i < elements.length; i++){
            somme += elements[i] * v.getElement(i);

        }
        return somme;
    }

    /**
     *
     * @return resultat nouvelle ecriture sous forme d'acolades
     */
    @Override
    public String toString() {
        String resultat = "{";
        for (int i = 0; i < elements.length; i++) {
            resultat += elements[i];
            if (i < elements.length - 1) {
                resultat += ",";
            }
        }
         resultat += "}";
         return resultat;
    }

    /**
     * Affiche le contenu du vecteur entre accolades
     */
    public void afficher(){
        System.out.println(this.toString());
    }
}