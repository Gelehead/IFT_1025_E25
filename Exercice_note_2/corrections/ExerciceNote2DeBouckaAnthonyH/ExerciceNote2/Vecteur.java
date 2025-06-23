//Codons la classe Vecteur

//Créeons la classe vecteur


public class Vecteur{
 private double[]elements;

//Créeomns le cosntructeur de vecteurs

public Vecteur(double[] elements){
    this.elements = new double[elements.length]; 
    for (int i=0; i<elements.length;i++){
            this.elements[i]=elements[i];
    }
}

//Créeons le setteur pour changer la chose a l'indice index avec valeur

public void setElement(int index, double valeur){
    elements[index]= valeur;
    }


    //Créeons un getteur

public double getElement(int index){

    return elements[index];
    
}


//Créeons une méthode qui calcule le produit scalaire entre deux vecteurs


public double dotProduct(Vecteur v){
    // on ajoute les verif

    if (this.elements.length != v.elements.length){
        System.err.println("erreur dans les dimensions des vecteurs");
        return Double.NaN;
    }




    double prodScal= 0;

    for (int i=0;i<elements.length;i++){
        prodScal+=this.elements[i]*v.elements[i];
    }
    return prodScal;    
}


//Créeons la méthode pour afficher

public void afficher(){

System.out.print("{");

for (int i=0;i<elements.length;i++){

    System.out.print(elements[i]);

if (i < elements.length -1){
    System.out.print(",");
 }
                              }
 System.out.println("}");


}

}







/*


public class Main {

    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        m3.afficher();

        // ...
    }
}


 */