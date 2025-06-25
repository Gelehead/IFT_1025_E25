/*
Exercice 2
IFT 1025
Par : Pierre-Luc Sasseville
Matricule : 20297694
Date : 2025-06-01
*/

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

        if (Test.mat_getline()) {
            System.out.println("VV mat_getline test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_getline test not passed");
        }

        if (Test.mat_getcol()) {
            System.out.println("VV mat_getcol test passed");
            passed_tests += 1;
        } else {
            System.out.println("XX mat_getcol test not passed");
        }

        System.out.println("Total tests passed : " + passed_tests);
    }
}

    class Test {
        // Tests Vecteurs
        public static boolean vec_rep() {
            double[] elements = {1, 2, 3, 4, 5};
            Vecteur v = new Vecteur(elements);

            return v.toString().equals("{1.0, 2.0, 3.0, 4.0, 5.0}");
        }

        public static boolean vec_dot() {
            double[] e1 = {1, 2};
            double[] e2 = {3, 4, 5};

            Vecteur v1 = new Vecteur(e1);
            Vecteur v2 = new Vecteur(e2);

            try {
                double result = v1.dotProduct(v2);
                return Double.isNaN(result);
            } catch (Exception e) {
                return false;
            }
        }

        public static boolean vec_set() {
            double[] e = {2, 4, 6, 8, 10};

            Vecteur v = new Vecteur(e);

            v.setElement(0, 7);

            return v.getElement(0) == 7;
        }

        public static boolean vec_get() {
            double[] e = {1, 3, 5, 7, 9};

            Vecteur v = new Vecteur(e);

            return v.getElement(2) == 5;
        }

        public static boolean vec_getelement_oob() {
            double[] e = {1, 2, 3};
            Vecteur v = new Vecteur(e);
            boolean failed = false;

            try {
                v.getElement(10); // Index hors limites
            } catch (ArrayIndexOutOfBoundsException e2) {
                failed = true;
            }

            return failed;
        }

        // Tests matrices
        public static boolean mat_dot_bad_dim() {
            Matrice A = new Matrice(2, 3);
            Matrice B = new Matrice(2, 2);

            return A.dotProduct(B) == null;
        }
        public static boolean mat_setget() {
            Matrice m = new Matrice(2, 2);
            m.setCell(0, 0, 1);
            m.setCell(0, 1, 2);
            m.setCell(1, 0, 3);
            m.setCell(1, 1, 4);

            return m.getCell(0, 0) == 1 &&
                    m.getCell(0, 1) == 2 &&
                    m.getCell(1, 0) == 3 &&
                    m.getCell(1, 1) == 4;
        }

        // test additionner scalaire
        public static boolean mat_addscalaire() {
            Matrice m = new Matrice(2, 2);
            m.additionnerScalaire(5.0);

            for (int i = 0; i < m.getLignes(); i++) {
                for (int j = 0; j < m.getColonnes(); j++) {
                    if (m.getCell(i, j) != 5.0) return false;
                }
            }
            return true;
        }

        // test multiplier scalaire
        public static boolean mat_multscalaire() {
            Matrice m = new Matrice(2, 2);
            m.setCell(0, 0, 1);
            m.setCell(0, 1, 2);
            m.setCell(1, 0, 3);
            m.setCell(1, 1, 4);

            m.multiplierScalaire(2.0);

            return m.getCell(0, 0) == 2 &&
                    m.getCell(0, 1) == 4 &&
                    m.getCell(1, 0) == 6 &&
                    m.getCell(1, 1) == 8;
        }

        // test transposee
        public static boolean mat_transpose() {
            Matrice m = new Matrice(2, 3);
            m.setCell(0, 0, 1); m.setCell(0, 1, 2); m.setCell(0, 2, 3);
            m.setCell(1, 0, 4); m.setCell(1, 1, 5); m.setCell(1, 2, 6);

            Matrice t = m.transpose();

            return t != null &&
                    t.getLignes() == 3 && t.getColonnes() == 2 &&
                    t.getCell(0, 0) == 1 &&
                    t.getCell(0, 1) == 4 &&
                    t.getCell(1, 0) == 2 &&
                    t.getCell(1, 1) == 5 &&
                    t.getCell(2, 0) == 3 &&
                    t.getCell(2, 1) == 6;
        }

        // test matrice identite
        public static boolean mat_identite() {
            Matrice m = Matrice.identite(3);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        if (m.getCell(i, j) != 1) return false;
                    } else {
                        if (m.getCell(i, j) != 0) return false;
                    }
                }
            }
            return true;
        }
        public static boolean mat_getcell_oob() {
            Matrice m = new Matrice(2, 2);
            boolean failed = false;

            try {
                m.getCell(10, 0); // Index hors limites
            } catch (ArrayIndexOutOfBoundsException e) {
                failed = true;
            }

            return failed;
        }
        public static boolean mat_getline() {
            Matrice m = new Matrice(2, 3);
            m.setCell(0, 0, 1.0);
            m.setCell(0, 1, 2.0);
            m.setCell(0, 2, 3.0);

            Vecteur ligne = m.getLine(0);
            return ligne.getElement(0) == 1.0 &&
                    ligne.getElement(1) == 2.0 &&
                    ligne.getElement(2) == 3.0;
        }
        public static boolean mat_getcol() {
            Matrice m = new Matrice(3, 2);
            m.setCell(0, 1, 4.0);
            m.setCell(1, 1, 5.0);
            m.setCell(2, 1, 6.0);

            Vecteur col = m.getCol(1);
            return col.getElement(0) == 4.0 &&
                    col.getElement(1) == 5.0 &&
                    col.getElement(2) == 6.0;
        }
    }




