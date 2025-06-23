public class Matrice {
    int lignes, colonnes;
    private double[][] data;

    /* Constructeur pour une matrice de taille Nlignes x Mcolonnes
     * remplie de zéros
     */
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.colonnes = cols;
        this.data = new double[lignes][colonnes];

        // Remplir avec des zéros (implicitement fait par Java)
    }

    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     * (modifie la matrice actuelle)
     */
    public void additionnerScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] += n;
            }
        }
    }

    /**
     * Multiplie toutes les cellules par un scalaire
     * (modifie la matrice actuelle)
     */
    public void multiplierScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] *= n;
            }
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices
     * (crée une nouvelle matrice de la bonne taille, ne modifie
     * pas les deux matrices originales)
     */
    public Matrice dotProduct(Matrice m){
        if (this.colonnes != m.lignes) {
            throw new Error("Dimensions incompatibles pour le produit matriciel");
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

    // Accesseur pour la cellule à une ligne/colonne donnée
    public double getCell(int ligne, int col){
        return data[ligne][col];
    }

    // Mutateur pour la cellule à une ligne/colonne donnée
    public void setCell(int ligne, int col, double valeur){
        data[ligne][col] = valeur;
    }

    // Retourne un nouveau vecteur contenant la Nième ligne
    public Vecteur getLine(int ligne){
        double[] line = new double[colonnes];
        for (int j = 0; j < colonnes; j++) {
            line[j] = data[ligne][j];
        }
        return new Vecteur(line);
    }

    // Retourne un nouveau vecteur contenant la Nième colonne
    public Vecteur getCol(int col){
        double[] column = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            column[i] = data[i][col];
        }
        return new Vecteur(column);
    }

    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     */
    public void afficher(){
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < colonnes; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Retourne une version transposée de la matrice
     * (sans modifier la matrice actuelle)
     */
    public Matrice transpose(){
        Matrice t = new Matrice(colonnes, lignes);

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                t.data[j][i] = this.data[i][j];
            }
        }

        return t;
    }

    /**
     * Retourne une instance de la matrice identité N x N
     */
    public static Matrice identite(int n){
        Matrice m = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            m.setCell(i, i, 1.0);
        }
        return m;
    }
}