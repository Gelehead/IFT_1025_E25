public class Matrice {
    private int lignes;
    private int cols;
    private double[][] tab;

    /**
     * Constructeur pour une matrice de taille Nlignes x Mcolonnes
     * remplie de zéros
     * 
     * @param lignes      nombre de lignes
     * @param cols        nombre de colonnes
     * @param kamiliaAmir
     */
    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        this.tab = new double[lignes][cols];
    }

    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     * (modifie la matrice actuelle)
     * 
     * @param n           valeur
     * @param kamiliaAmir
     */
    public void additionnerScalaire(double n) {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < cols; j++) {
                tab[i][j] += n;
            }
        }
    }

    /**
     * Multiplie toutes les cellules par un scalaire
     * (modifie la matrice actuelle)
     * 
     * @param n           valeur
     * @param kamiliaAmir
     */
    public void multiplierScalaire(double n) {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < cols; j++) {
                tab[i][j] *= n;
            }
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices
     * (crée une *nouvelle matrice* de la bonne taille, ne modifie
     * pas les deux matrices originales)
     * 
     * @param m           matrice
     * @param kamiliaAmir
     * @return retourne le produit matriciel entre deux matrices
     */

    public Matrice dotProduct(Matrice m) {
        // Si les dimensions des matrices multipliées ne sont pas cohérentes
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;

        }
        Matrice product = new Matrice(this.lignes, m.cols);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.tab[i][k] * m.tab[k][j];
                }
                product.tab[i][j] = sum;
            }
        }
        return product;
    }

    /**
     * Accesseur pour la cellule à une ligne/colonne donnée
     * 
     * @param ligne       index de la ligne
     * @param col         index de la colonne
     * @param kamiliaAmir
     * @return la valeur a une ligne/colonne donnée
     * 
     */
    public double getCell(int ligne, int col) {
        return tab[ligne][col];
    }

    /**
     * Mutateur pour la cellule à une ligne/colonne donnée
     * 
     * @param ligne       index de la ligne
     * @param col         index de la colonne
     * @param valeur      valeur
     * @param kamiliaAmir
     */
    public void setCell(int ligne, int col, double valeur) {
        tab[ligne][col] = valeur;
    }

    /**
     * Retourne un nouveau vecteur contenant la Nième ligne
     * 
     * @param ligne       index de la ligne
     * @param kamiliaAmir
     * @return retourne un nouveau vecteur contenant la Nième ligne
     */
    public Vecteur getLine(int ligne) {
        double[] vector = new double[cols];
        for (int j = 0; j < cols; j++) {
            vector[j] = tab[ligne][j];
        }
        return new Vecteur(vector);
    }

    /**
     * Retourne un nouveau vecteur contenant la Nième colonne
     * 
     * @param col         index de la colonne
     * @param kamiliaAmir
     * @return retourne un nouveau vecteur contenant la Nième colonne
     */
    public Vecteur getCol(int col) {
        double[] vector = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            vector[i] = tab[i][col];
        }
        return new Vecteur(vector);
    }

    /**
     * Retourne une version transposée de la matrice
     * (sans modifier la matrice actuelle)
     * 
     * @param kamiliaAmir
     * @return retourne une version transposée de la matrice
     */
    public Matrice transpose() {
        Matrice transMat = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                transMat.tab[j][i] = this.tab[i][j];
            }
        }
        return transMat;
    }

    /**
     * Retourne une instance de la matrice identité N x N
     * 
     * @param n           taille de la matrice
     * @param kamiliaAmir
     * @return une instance de la matrice identité N x N
     */
    public static Matrice identite(int n) {
        Matrice idMat = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            idMat.tab[i][i] = 1.0;
        }
        return idMat;
    }

    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     * Par exemple, la matrice qui contient les nombres 1 et 2 sur la
     * première ligne et 13 et 14 sur la deuxième ligne sera affichée
     * avec :
     * [ 1.0 2.0 ]
     * [ 13.0 14.0 ]
     * 
     * @param kamiliaAmir
     */
    public void afficher() {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getLignes() {
        return this.lignes;
    }

    public int getColonnes() {
        return this.cols;
    }

}