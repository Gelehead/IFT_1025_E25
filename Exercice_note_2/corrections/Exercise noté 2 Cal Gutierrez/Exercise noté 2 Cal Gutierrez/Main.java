public class Main {
    public static void main(String[] args) {
        testVecteurs();
        testsMatrices();
    }

    public static void testProduitScalaireVecteur(Vecteur v1, Vecteur v2) {
        double produitScalaire = v1.dotProduct(v2);

        if(!Double.isNaN(produitScalaire))
            System.out.println(produitScalaire);
        else
            System.out.println("Le produit scalaire n'est pas défini.");
    }

    public static void testProduitScalaireMatrice(Matrice m1, Matrice m2) {
        Matrice produitScalaire = m1.dotProduct(m2);

        if(produitScalaire != null)
            produitScalaire.afficher();
        else
            System.out.println("Le produit scalaire n'est pas défini.");
    }

    public static void testVecteurs(){
        double[] elements = new double[]{1, 2, 3};
        double[] elements2 = new double[]{0, 1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);
        Vecteur v3 = new Vecteur(elements2);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();
        v3.afficher();

        int index = 3;
        double compo = v3.getElement(index-1);
        System.out.println("La valeur de la composante #" + index + " du vecteur v3 est " + compo);

        System.out.println(v1.toString() + " x " + v2.toString() + " = ");
        testProduitScalaireVecteur(v1, v2); //Bon test
        System.out.println(v1.toString() + " x " + v3.toString() + " = ");
        testProduitScalaireVecteur(v1, v3); //Edge case
    }

    public static void testsMatrices(){
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

        Matrice tm2 = m2.transpose();
        System.out.println("Matrice 2 transposé :");
        tm2.afficher();

        int col = 2;
        int row = 2;

        Vecteur mcol =  m1.getCol(col-1);
        Vecteur mrow = m1.getLine(row-1);
        Double compo = m1.getCell(row-1, col-1);;
        System.out.println("Ligne #" + row + " de la matrice 1: " + mrow.toString());
        System.out.println("Colonne #" + col + " de la matrice 1: " + mcol.toString());
        System.out.println("L'élément (" + row + " ," + col + ") de la matrice 1 est: " + compo);

        System.out.println("m1 x m2 :");
        testProduitScalaireMatrice(m1, m2); //devrais marcher
        System.out.println("m2 x m3 :");
        testProduitScalaireMatrice(m2, m1); //ne devrais pas marcher
    }
}
