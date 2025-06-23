// Florencia Jhon Locht, date:25-05-2025 , File: Vecteur.java
// Ce programme est la classe Vecteur et toutes ses fonctionnalités.
public class Vecteur {
    // Variable :
    private double[] elements;

    /**
     * Constructeur avec en paramètre un tableau d'éléments de type
     * 'double'
    */
    public Vecteur(double[] elements){
        int n = elements.length;
        double[] vecElements = new double[n];
        vecElements = copier(elements);
        this.elements = vecElements;
    }

    public double[] copier(double[] tab){
        int n = tab.length;
        double[] copie = new double[n];
        for(int i=0; i<n; i++){
            copie[i] = tab[i];
        }
        return copie;
    }

    // Retourne la longueur du vecteur.
        public int length(){
        return this.elements.length;
    }

    /**
     * Permet de changer la valeur à l'index donné (commence à 0,
     * comme dans un tableau)
    */
    public void setElement(int index, double valeur){
        this.elements[index] = valeur;
    }

    // Retourne la valeur à l'index demandé.
    public double getElement(int index){
        return this.elements[index];
    }

    // Calcule le produit scalaire avec un autre vecteur.
    public double dotProduct(Vecteur v){
        // Vérification des dimensions :
        if(v.length() != this.elements.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        else{
            // Variables :
            int n = this.elements.length;
            double produit = 0;
            // Produit scalaire :
            for(int i=0; i<n; i++){
                produit += v.getElement(i)*this.elements[i];
            }
            return produit;
        }
    }


    @Override
    public String toString(){
         // Variables :
        int n = this.elements.length;
        String interieur = "";
        double valeur;
        // Transformer les éléments du vecteur en string :
        for(int i=0; i<n; i++){
            valeur = this.getElement(i);
            interieur += Double.toString(valeur);

            if(i<n-1){
                interieur += ", ";
            }
        }
        // String :
        String vecString = "{"+ interieur +"}";
        return vecString;
    }

    /**
    * Affiche le contenu du vecteur entres accolades sur la console.
    * Par exemple, le vecteur qui contient les nombres 1,2 et 3 sera
    * affiché avec :
    * {1.0, 2.0, 3.0}
    */
    public void afficher(){
        System.out.println(this.toString());
    }
}