/**
 * Classe représentant une matrice de nombres réels (double).
 */
public class Matrice {
    // Tableau 2D contenant les éléments de la matrice
    private double[][] data;

    // Nombre de lignes de la matrice
    private int lignes;

    // Nombre de colonnes de la matrice
    private int colonnes;

    /**
     * Constructeur : initialise une matrice vide (remplie de 0.0) de dimensions données.
     *
     * @param lignes nombre de lignes
     * @param cols nombre de colonnes
     */
    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.colonnes = cols;
        this.data = new double[lignes][cols];
    }

    /**
     * Additionne un scalaire à chaque case de la matrice.
     *
     * @param n le nombre à ajouter à chaque élément
     */
    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] += n;
            }
        }
    }

    /**
     * Multiplie chaque élément de la matrice par un scalaire.
     *
     * @param n le nombre par lequel multiplier chaque élément
     */
    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] *= n;
            }
        }
    }

    /**
     * Calcule le produit matriciel entre cette matrice et une autre.
     * Si les dimensions ne conviennent pas, affiche une erreur et retourne null.
     *
     * @param m la matrice à multiplier
     * @return le résultat du produit matriciel (ou null si les dimensions sont incorrectes)
     */
    public Matrice dotProduct(Matrice m) {
        if (this.colonnes != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice result = new Matrice(this.lignes, m.colonnes);

        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.colonnes; j++) {
                double sum = 0;
                for (int k = 0; k < this.colonnes; k++) {
                    sum += this.data[i][k] * m.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    /**
     * Retourne l'élément situé à une position (ligne, colonne).
     *
     * @param ligne la ligne à lire
     * @param col la colonne à lire
     * @return la valeur dans la case demandée
     */
    public double getCell(int ligne, int col) {
        return data[ligne][col];
    }

    /**
     * Modifie la valeur d'une cellule de la matrice.
     *
     * @param ligne ligne de la case à modifier
     * @param col colonne de la case à modifier
     * @param valeur nouvelle valeur à mettre
     */
    public void setCell(int ligne, int col, double valeur) {
        data[ligne][col] = valeur;
    }

    /**
     * Retourne la ligne indiquée sous forme de vecteur.
     *
     * @param ligne numéro de la ligne
     * @return un vecteur correspondant à la ligne demandée
     */
    public Vecteur getLine(int ligne) {
        return new Vecteur(data[ligne]);
    }

    /**
     * Retourne la colonne indiquée sous forme de vecteur.
     *
     * @param col numéro de la colonne
     * @return un vecteur correspondant à la colonne demandée
     */
    public Vecteur getCol(int col) {
        double[] colonne = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colonne[i] = data[i][col];
        }
        return new Vecteur(colonne);
    }

    /**
     * Affiche la matrice ligne par ligne dans la console.
     */
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < colonnes; j++) {
                System.out.print(data[i][j]);
                if (j != colonnes - 1) System.out.print(" ");
            }
            System.out.println(" ]");
        }
    }

    /**
     * Retourne la transposée de la matrice.
     * La transposée échange les lignes et les colonnes.
     *
     * @return une nouvelle matrice transposée
     */
    public Matrice transpose() {
        Matrice t = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                t.data[j][i] = data[i][j];
            }
        }
        return t;
    }

    /**
     * Crée une matrice identité de taille n x n.
     * Tous les éléments de la diagonale sont 1, le reste est 0.
     *
     * @param n taille de la matrice
     * @return matrice identité
     */
    public static Matrice identite(int n) {
        Matrice id = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            id.data[i][i] = 1;
        }
        return id;
    }

    /**
     * Retourne le nombre de lignes de la matrice.
     *
     * @return nombre de lignes
     */
    public int getLignes() {
        return lignes;
    }

    /**
     * Retourne le nombre de colonnes de la matrice.
     *
     * @return nombre de colonnes
     */
    public int getColonnes() {
        return colonnes;
    }
}
