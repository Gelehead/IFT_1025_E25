public class Vecteur {

    public double[] vector;
    private double[] tableau;

    public Vecteur(double[] elements){ //Constructeur avec en paramètre un tableau d'éléments de type 'double'
        this.tableau = new double[elements.length]; //empêche que la modification du tableau passé affecte le vecteur
        System.arraycopy(elements, 0, this.tableau, 0, elements.length);

        this.vector = elements;
    }

    public void setElement(int index, double valeur){ //Permet de changer la valeur à l'index donné
        this.vector[index] = valeur;
    }

    public double getElement(int index){ //Retourne la valeur à l'index demandé
        return this.vector[index];
    }

    public double dotProduct(Vecteur v){  //Calcule le produit scalaire avec un autre vecteur
        double dp = 0.0;
        //Pour faire un produit scalaire, deux vecteur doivent avoir le meme nb d'éléments
        if (this.vector.length == v.vector.length) {
            for (int i = 0; i < this.vector.length; i++) {
                dp += this.vector[i] * v.vector[i];
            }
        }else{
            System.err.println("Erreur dans les dimensions des vecteurs");
            dp = Double.NaN;
        }
        return dp;
    }

    public int getSize(){ //Retourne la taille
        return this.vector.length;
    }

    @Override
    public String toString(){ //Formate le contenu du vecteur entre des accolades
        String ligne;
        ligne = "{ ";
        for (int i = 0; i < this.vector.length; i++) {      // columns
            ligne = ligne.concat(String.valueOf(this.vector[i])).concat(" ");
        }
        ligne = ligne.concat("}");
        return ligne;
    }

    public void afficher(){  //Affiche le contenu du vecteur sur la console.
        System.out.println(this.toString());
    }
}