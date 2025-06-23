
public class Vecteur {

    private double[] valeurs;

    //  Constructeur avec en paramètre un tableau d'éléments de type `double`
    public Vecteur(double[] elements){
        this.valeurs = new double[elements.length]; //creer le tableau
        for(int i=0; i<elements.length; i++){
            this.valeurs[i] = elements[i];    //copier dans le nouveau tableau

        }
    }
        //Permet de changer la valeur à l'index donné (commence à 0, comme dans un tableau)
    public void setElement(int index, double valeur){
        this.valeurs[index] = valeur;

    }
    // Retourne la valeur à l'index demandé
    public double getElement(int index){

        return this.valeurs[index];
    }
     //  Calcule le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v){
        // Si les dimensions des vecteurs multipliés ne sont pas cohérentes
        if(this.valeurs.length != v.valeurs.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double somme= 0; // commence le produit scalaire
        for(int i=0; i<this.valeurs.length; i++){
            somme += this.valeurs[i]*v.valeurs[i];
        }
        return somme;
    }


    @Override
    //Affiche le contenu du vecteur entres accolades sur la console.
    // Par exemple, le vecteur qui contient les nombres 1,2 et 3 sera
    // affiché avec : {1.0, 2.0, 3.0}
    public String toString(){
        String resultat  = "{";
        for(int i=0; i<this.valeurs.length; i++){
            resultat += this.valeurs[i] ;  // ajouter le nombre

        // si c'est paa la dernière nombre ,ajouter le virgule
           if( i < this.valeurs.length-1){
            resultat += ", ";
           }
        }

        resultat += "}";
        return resultat;
    }

     //afficher
    public void afficher(){
        System.out.println(this.toString());
    }
}