/** Parsa Makari
 * Matricule 20121030
 * 01/06/25
 */
public class Vecteur{
    
    private double[] elements;

    //Constructeur. Prend en entree un tableau simple de valeurs double.
    public Vecteur(double[] elements){
        this.elements = elements.clone(); //Evite d'utiliser la meme ref que la liste.
    }
    
   //change la valeur du vecteur a l index. doesnt return.
    public void setElement(int index, double value){
            elements[index] = value;
    }

    //returns value at given index. returns a double.
    public double getElement(int index){
        return elements[index];
    }

    //produit scalaire de deux vecteurs. returns a double.
    public double dotProduct(Vecteur v){
        if (v.elements.length == this.elements.length){
            double somme = 0.0;
            for(int i=0; i<this.elements.length; i++){
                somme += v.elements[i] * this.elements[i];
            }
            return somme; 
        }
        else{
            System.out.println("Les vecteurs sont de tailles differentes");
            return Double.NaN; // erreur if size doesnt match
        }
    } 

    //reecrit la methode toString(), on veut afficher le vecteur et non la case memoire.  returns String.
    @Override
    public String toString(){ // to be used with afficher()
        String vecToShow = "{";
        Boolean control = false; // pas de virgule avant le premier element de la liste.
        for (int i=0; i<this.elements.length; i++){
            if (control){
                vecToShow += ", ";
            }
            vecToShow += String.valueOf(this.elements[i]);
            control = true;
        }
        vecToShow += "}";
        return (vecToShow);
    }

    //affiche le vecteur au console. Doesnt return.
    public void afficher(){
            System.out.println(this.toString());
    }

}
