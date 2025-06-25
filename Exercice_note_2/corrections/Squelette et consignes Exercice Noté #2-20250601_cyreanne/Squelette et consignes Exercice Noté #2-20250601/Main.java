public class Main {
    public static void main(String[] args) {

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

    

    //-----------------------------------------------------------------------------------
    //Cyreanne Andrianefa, 20236570
    double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        //getElement()
        System.out.println("v1[1] = " + v1.getElement(1));

        //dotProduct()
        System.out.println("Produit scalaire : " + v1.dotProduct(v2));

        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        //getCell
        System.out.println(m1.getCell(1, 0));

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        if (m3 != null) {
            m3.afficher();
        }

        //transpose()
        System.out.println("La transposée de m1  est:");
        Matrice mt = m1.transpose();
        mt.afficher();

        //getLine() et getCol()
        System.out.println("Ligne 0 de m1 est: " + m1.getLine(0));
        System.out.println("Col 1 de m1 est: " + m1.getCol(1));

        //getLignes() et getColonnes()
        System.out.println("m1 possède " + m1.getLignes() + " lignes et " + m1.getColonnes() + " colonnes.");
    }
}
