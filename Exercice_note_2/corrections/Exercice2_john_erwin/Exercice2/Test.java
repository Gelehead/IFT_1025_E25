public class Test {
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

}