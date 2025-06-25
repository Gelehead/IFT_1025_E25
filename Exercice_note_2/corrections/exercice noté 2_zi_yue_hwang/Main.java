/**
 * Nom : Ziyue Wang
 * Date : 1 juin 2025
 * Matricule : 22308297
 * Ce programme permet de manipuler des vecteurs et matrices en Java avec leurs 
 * opérations essentielles (produit scalaire, multiplication, addition, transposition),
 * tout en respectant l'encapsulation et en gérant les erreurs de dimensions. 
 * Il est organisé en plusieurs fichiers - Main.java, Matrice.java et Vecteur.java -
 * et est validé par des tests garantissant que toutes les fonctionnalités demandées
 * fonctionnent correctement. 
 */

public class Main {
    public static void main(String[] args) {
        // -----vecteurs------
        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
       
        // test setElement (modifie la copie seulement)
        v2.setElement(0, 10);

        // test toString
        System.out.println("toString v1 :" + v1.toString());

        System.out.println("--- Vecteurs ---");
        v1.afficher(); // {1.0, 2.0, 3.0}
        v2.afficher(); // {10.0, 2.0, 3.0}

        // test GetElement 
        System.out.println("v1[1] =" + v1.getElement(1));

        // test dotProduct
        double produitScalaire = v1.dotProduct(v2);
        System.out.println("v1 · v2 =" + produitScalaire);

        // ------ matrices -----
        System.out.println("--- Matrices ---");
       
        // identité, multiplication scalaire et setCell
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
       
        System.out.println("Matrice 1 :");
        m1.afficher();

        // matrice remplie, addition scalaire
        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
       
        System.out.println("Matrice 2 :");
        m2.afficher();

        // produit matriciel
        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        m3.afficher();
        
        // test getCell
        System.out.println("m1[0][1] =" + m1.getCell(0, 1));

        // tesr getLignes et getColonnes
        System.out.println("m1 lignes =" + m1.getLignes() +", colonnes =" + m1.getColonnes());
        
        // test dimensions invalides (dotProduct)
        Matrice m4 = new Matrice(3, 3);
        Matrice erreur = m1.dotProduct(m4);
        if (erreur == null) {
            System.out.println("Produit matriciel invalide détecté.");
        }

        // test transposition 
        Matrice m5 = m1.transpose();
        System.out.println("Transposée de m1 :");
        m5.afficher();

        // test création d'identité différente
        Matrice m6 = Matrice.identite(3);
        System.out.println("Identité 3x3 :");
        m6.afficher();

        // test additionnerScalaire sur matrice vide ou de taille différente
        Matrice m7 = new Matrice(3, 3);
        m7.additionnerScalaire(7);
        System.out.println("m7 après additionnerScalaire(7) :");
        m7.afficher();

        // test multiplierScalaire sur matrice vide
        m7.multiplierScalaire(2);
        System.out.println("m7 après multiplierScalaire(2) ;");
        m7.afficher();

        // test transpose sur matrice non carrée
        Matrice m8 = new Matrice(2,3);
        m8.setCell(0,0, 1);
        m8.setCell(0,1, 2);
        m8.setCell(0,2, 3);
        m8.setCell(1,0, 4);
        m8.setCell(1,1, 5);
        m8.setCell(1,2, 6);
        System.out.println("m8 :");
        m8.afficher();

        Matrice m8T = m8.transpose();
        System.out.println("Transpose de m8 :");
        m8T.afficher();

        // Tests publics 
        int passed_tests = 0;

        // vecteurs
        if ( Test.vec_dot() ) {
            System.out.println("VV vector dot product test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX vector dot product test not passed");
        }
        
        if ( Test.vec_get() ) {
            System.out.println("VV vector get test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX vector get test not passed");
        }
        
        if ( Test.vec_rep() ) {
            System.out.println("VV vector representation test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX Vector representation test not passed");
        }

        if ( Test.vec_set() ) {
            System.out.println("VV vector set test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX vector set test not passed");
        }

        if ( Test.vec_getelement_oob() ) {
            System.out.println("VV vec_getelement_oob test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX vec_getelement_oob test not passed");
        }

        // Matrice 
        if (Test.mat_dot_bad_dim()) {
            System.out.println("VV mat_dot_bad_dim test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_dot_bad_dim test not passed");
        }

        if (Test.mat_setget()) {
            System.out.println("VV mat_setget test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_setget test not passed");
        }

        if (Test.mat_addscalaire()) {
            System.out.println("VV mat_addscalaire test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_addscalaire test not passed");
        }

        if (Test.mat_multscalaire()) {
            System.out.println("VV mat_multscalaire test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_multscalaire test not passed");
        }

        if (Test.mat_transpose()) {
            System.out.println("VV mat_transpose test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_transpose test not passed");
        }

        if (Test.mat_identite()) {
            System.out.println("VV mat_identite test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_identite test not passed");
        }

        if (Test.mat_getcell_oob()) {
            System.out.println("VV mat_getcell_oob test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_getcell_oob test not passed");
        }

        System.out.println("Total tests passed : " + passed_tests);

    }
}
