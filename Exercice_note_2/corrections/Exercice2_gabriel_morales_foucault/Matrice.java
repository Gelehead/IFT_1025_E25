public class Matrice {
    private double[][] matrice;

    public Matrice(int lignes, int cols) {
        matrice = new double[lignes][cols];
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                matrice[i][j] = 0;
            }
        }
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        int ligneA = this.matrice.length;
        int colA = this.matrice[0].length;
        int ligneB = m.matrice.length;
        int colB = m.matrice[0].length;

        if (colA != ligneB) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice nouvelleMatrice = new Matrice(ligneA, colB);

        for (int i = 0; i < ligneA; i++) {
            for (int j = 0; j < colB; j++) {
                double produit = 0.0;
                for (int k = 0; k < colA; k++) {
                    produit += this.matrice[i][k] * m.matrice[k][j];
                }
                nouvelleMatrice.matrice[i][j] = produit;
            }
        }
        return nouvelleMatrice;
    }

    public double getCell(int ligne, int col) {
        double val = this.matrice[ligne][col];
        return val;
    }

    public void setCell(int ligne, int col, double valeur) {
        this.matrice[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne) {
        Vecteur newVectLigne = new Vecteur(this.matrice[ligne]);
        return newVectLigne;
    }

    public Vecteur getCol(int col) {
        int ligne = this.matrice.length;
        double[] colonne = new double[ligne];
        for (int i = 0; i < ligne; i++) {
            colonne[i] = this.matrice[i][col];
        }
        return new Vecteur(colonne);
    }

    public void afficher() {
        for (int i = 0; i < matrice.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose() {
        int ligne = this.matrice.length;
        int col = this.matrice[0].length;

        Matrice transposeMatrice = new Matrice(col, ligne);

        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < col; j++) {
                transposeMatrice.matrice[j][i] = this.matrice[i][j];
            }
        }
        return transposeMatrice;
    }

    public static Matrice identite(int n) {
        Matrice identiteMatrice = new Matrice(n, n);

        for (int i = 0; i < n; i++) {
            identiteMatrice.matrice[i][i] = 1.0;
        }
        return identiteMatrice;
    }
}
