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
        System.out.println("Matrice 3 representant le produit matricielle m1*m2 : ");
        m3.afficher();

        System.out.println("Matrice identite:");
        Matrice identite = Matrice.identite(3);
        identite.afficher();

        System.out.println("on ajoute un 1 dans tout la matrice identite: ");
        identite.additionnerScalaire(1);
        identite.afficher();

        System.out.println("on multiplie par 2 dans tout la matrice identite: ");
        identite.multiplierScalaire(2);
        identite.afficher();

        System.out.println("on donne la valeur 99 a la matrice identite[3][3] ");
        identite.setCell(2,2,99);
        identite.afficher();

        System.out.println("on accede a la valeur dans les coordones [2][2] : " + identite.getCell(2,2));

        System.out.println("retourne la 2eme colonne de la matrice precedente: ");
        Vecteur c2 = identite.getCol(1);
        c2.afficher();

        System.out.println("retourne la 3eme ligne de la matrice identite: ");
        Vecteur l3 = identite.getLine(2);
        l3.afficher();

        System.out.println("on change la valeur contenu dans [0] dans le vecteur l3 par 7 ");
        l3.setElement(0,7);
        l3.afficher();

        double resultatScalaire =c2.dotProduct(l3);
        System.out.println("On calcule le produit scalaire de c2 et l3:" + resultatScalaire);

        System.out.println("Matrice originale");
        m1.afficher();

        System.out.println("Matrice transpose");
        Matrice m6 = m1.transpose();
        m6.afficher();


    }
}
