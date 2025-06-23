public class Vecteur {

    // Encapsulation : On cache les éléments
    private final double [] elements;

    // Constructeur : On fait une copie défensive
    public Vecteur(double[] elements){
        this.elements = elements.clone();
    }

    // Modifier la valeur de l'index spécifié
    // Une exception est levée en cas de dépassement de la limite
    public void setElement(int index, double valeur){
        elements[index] = valeur;
    }

    // Obtenir la valeur de l'index spécifié
    public double getElement(int index){
        return elements[index];
    }

    // Calculer le produit scalaire avec un autre vecteur
    // Si les dimensions ne correspondent pas,
    // une erreur d'impression se produit et NaN est renvoyé
    public double dotProduct(Vecteur v){
        if (v.elements.length != this.elements.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double sum = 0;
        for (int i = 0; i < elements.length; i++){
            sum += this.elements[i] * v.elements[i];
        }
        return sum;
    }

    // Réécrire toString pour renvoyer une chaîne au format « {a, b, c} »
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < elements.length; i++){
            result.append(elements[i]);
            if (i < elements.length - 1){
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }

    // Imprimer le contenu vectoriel dans la console
    // Appeler directement toString()
    public void afficher(){
        System.out.println(this.toString());
    }
}