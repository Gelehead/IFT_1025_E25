/*
 * Titre : Bibliothèque de calcul matriciel
 * Auteur : Ruoxuan Hu
 * Matricule : 20304027
 * Date : le 29 Mai, 2025
 * La classe Main illustre l'utilisation de ces deux classes à travers une
 *  série d'exemples : création, affichage, calculs, ainsi que la gestion des
 * incompatibilités de dimensions (affichage d'erreurs et valeurs retournées spéciales).
 
/* Main.java */
// Classe Main : tests manuels et automatisés de Vecteur et Matrice
public class Main {
    // Fonction main : exécute tous les tests
    public static void main(String[] args) {
        // --- Tests manuels des vecteurs ---
        // Initialisation des données de test
        double[] elems = {1, 2, 3};
        // Création des objets Vecteur
        Vecteur v1 = new Vecteur(elems);
        Vecteur v2 = new Vecteur(elems);
        // Modification de v2 pour tester setElement
        v2.setElement(0, 10);
        // Affichage des vecteurs
        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();
        // Test getElement
        System.out.println("getElement(0) = " + v2.getElement(0));
        // Test du produit scalaire valide
        System.out.println("Produit scalaire = " + v1.dotProduct(v2));
        // Test du produit scalaire avec dimensions incompatibles
        System.out.println("Produit scalaire erreur = " +
            v1.dotProduct(new Vecteur(new double[]{1,2})));        

        // --- Tests manuels des matrices ---
        // Création et modification de la matrice identité
        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0,1,5);
        m1.setCell(1,0,-2);
        // Affichage de m1
        System.out.println("Matrice m1 :");
        m1.afficher();
        // Création et modification de m2
        Matrice m2 = new Matrice(2,1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice m2 :");
        m2.afficher();
        // Test du produit matriciel
        Matrice m3 = m1.dotProduct(m2);
        System.out.println("M1·M2 :");
        m3.afficher();
        // Test dimensions incompatibles
        System.out.print("Erreur dimensions m2·m1 = ");
        System.out.println(m2.dotProduct(m1));
        // Test getCell et setCell
        System.out.println("getCell(0,1) = " + m1.getCell(0,1));
        m1.setCell(0,1,7);
        System.out.println("Après setCell(0,1,7) :");
        m1.afficher();
        // Extraction ligne, colonne et transpose
        System.out.println("getLine(1) :");
        m1.getLine(1).afficher();
        System.out.println("getCol(0) :");
        m1.getCol(0).afficher();
        System.out.println("Transpose :");
        m1.transpose().afficher();

        // --- Exécution des tests publics automatisés ---
        // Initialisation du compteur
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
