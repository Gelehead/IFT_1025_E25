public class Matrice {

    // Attributs privés : nombre de lignes, nombre de colonnes et les cellules de la matrice
    private int lignes;
    private int colonnes;
    private double[][] cellules;

    // Constructeur : initialise une matrice vide (remplie de zéros)
    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.colonnes = cols;
        this.cellules = new double[lignes][cols];
    }

    // Méthode : ajoute un scalaire à chaque élément de la matrice
    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                cellules[i][j] += n;
            }
        }
    }

    // Méthode : multiplie chaque élément de la matrice par un scalaire
    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                cellules[i][j] *= n;
            }
        }
    }

    // Méthode : produit matriciel (dot product) entre deux matrices
    public Matrice dotProduct(Matrice m) {
        // Vérifie la compatibilité des dimensions
        if (this.colonnes != m.lignes) return null;

        Matrice resultat = new Matrice(this.lignes, m.colonnes);

        // Calcul du produit matriciel
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.colonnes; j++) {
                double somme = 0;
                for (int k = 0; k < this.colonnes; k++) {
                    somme += this.cellules[i][k] * m.cellules[k][j];
                }
                resultat.setCell(i, j, somme);
            }
        }

        return resultat;
    }

    // Retourne l’élément à la position (ligne, colonne)
    public double getCell(int ligne, int col) {
        return cellules[ligne][col];
    }

    // Définit une valeur à la position (ligne, colonne)
    public void setCell(int ligne, int col, double valeur) {
        cellules[ligne][col] = valeur;
    }

    // Retourne la ligne `ligne` sous forme d’un Vecteur
    public Vecteur getLine(int ligne) {
        return new Vecteur(cellules[ligne]);
    }

    // Retourne la colonne `col` sous forme d’un Vecteur
    public Vecteur getCol(int col) {
        double[] colonne = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colonne[i] = cellules[i][col];
        }
        return new Vecteur(colonne);
    }

    // Affiche la matrice dans la console
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print(cellules[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Retourne la transposée de la matrice
    public Matrice transpose() {
        Matrice trans = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                trans.setCell(j, i, cellules[i][j]);
            }
        }
        return trans;
    }

    // Méthode statique : crée une matrice identité de taille `n`
    public static Matrice identite(int n) {
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.setCell(i, i, 1.0);
        }
        return identite;
    }

    // Retourne le nombre de lignes
    public int getLignes() {
        return lignes;
    }

    // Retourne le nombre de colonnes
    public int getColonnes() {
        return colonnes;
    }
}
