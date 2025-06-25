// Gabriel Morales Foucault
// 2025-06-01

public class Main {

    public static void main(String[] args) {

        double[] test = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(test);
        Vecteur v2 = new Vecteur(test);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();
        System.out.println("v2.getElement[0]: " + v2.getElement(0));
        System.out.println("dotProduct: " + v1.dotProduct(v1));

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

        System.out.println("m1.getCell(0,1): " + m1.getCell(0, 1));

        Matrice m4 = Matrice.identite(3);
        System.out.println("Matrice 4 :");
        System.out.println("getLine(2): " +m4.getLine(2));
        System.out.println("getCol(1): " + m4.getCol(1));

        Matrice m5 = new Matrice(2,2);

        System.out.println("Matrice 5 :");
        m5.setCell(0, 1, 60);
        m5.setCell(1, 0, 80);
        m5.afficher();
        System.out.println("Matrice m5 transpose: ");
        Matrice transpo = m5.transpose();
        transpo.afficher();




    }
}