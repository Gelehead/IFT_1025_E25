public class Matrice {

    private double[][] elements;
    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols) {
    
        this.lignes = lignes;
        this.cols = cols;
        this.elements = new double[lignes][cols];
    }

    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] += n;
            }
        }
    }

    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] *= n;
            }
        }
    }

    public Matrice dotProduct(Matrice m) {
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice resultat = new Matrice(this.lignes, m.cols);
        for (int i = 0; i < resultat.lignes; i++) {
            for (int j = 0; j < resultat.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    resultat.elements[i][j] += this.elements[i][k] * m.elements[k][j];
                }
            }
        }
        return resultat;
    }

    public double getCell(int ligne, int col) {
        return elements[ligne][col];
    }

    public void setCell(int ligne, int col, double valeur) {
        elements[ligne][col] = valeur;
    }

    public Vecteur getLine(int ligne) {
        return new Vecteur(elements[ligne]);
    }

    public Vecteur getCol(int col) {
        double[] colonne = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colonne[i] = elements[i][col];
        }
        return new Vecteur(colonne);
    }

    public void afficher() {
    
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrice transpose() {
        
        Matrice transposee = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                transposee.elements[j][i] = elements[i][j];
            }
        }
        return transposee;
    }

    public static Matrice identite(int n) {
    
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.elements[i][i] = 1.0;
        }
        return identite;
    }

}
