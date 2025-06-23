public class Matrice {
    private double[][] grille;
    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        grille = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                grille[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                grille[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice resultat = new Matrice(this.lignes, m.cols);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                double somme = 0;
                for (int k = 0; k < this.cols; k++) {
                    somme += this.grille[i][k] * m.grille[k][j];
                }
                resultat.grille[i][j] = somme;
            }
        }

        return resultat;
    }

    public double getCell(int ligne, int col) {
        return grille[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur) {
        grille[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne) {
        return new Vecteur(grille[ligne]);
    }

    public Vecteur getCol(int col) {
        double[] colonne = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colonne[i] = grille[i][col];
        }
        return new Vecteur(colonne);
    }

    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose() {
        Matrice t = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                t.grille[j][i] = this.grille[i][j];
            }
        }
        return t;
    }

    public static Matrice identite(int n) {
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.grille[i][i] = 1.0;
        }
        return identite;
    }
        public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return cols;
    }
}


