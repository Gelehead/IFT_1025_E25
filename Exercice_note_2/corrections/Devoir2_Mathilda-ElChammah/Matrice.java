public class Matrice{
    private final double[][] data;
    private final int lignes;
    private final int colonnes; 
    

    /**
     * Constructeur pour une matrice de taille Nlignes x Mcolonnes.
     * remplie de zéros
     */
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.colonnes = cols;
        this.data = new double[lignes][colonnes];
    }


    /**
     * Additionne la valeur n dans toutes les cellules de la matrice.
     */
    public void additionnerScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] += n;
            }
        }
    }


    /**
     * Multiplie toutes les cellules par un scalaire.
     */
    public void multiplierScalaire(double n){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                data[i][j] *= n;
            }
        }
    }


    /** 
     * Fait le produit matriciel entre deux matrices.
     */
    public Matrice dotProduct(Matrice m){ 
        if (this.colonnes != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice result = new Matrice(this.lignes, m.colonnes);
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.colonnes; j++) {
                double somme = 0;
                for (int k = 0; k < this.colonnes; k++) {
                    somme += this.data[i][k] * m.data[k][j];
                }
                result.data[i][j] = somme;
            }
        }
        return result;
    }


    /** 
     * Accesseur pour la cellule à une ligne/colonne donnée.
     */
    public double getCell(int ligne, int col){
        return data[ligne][col];
    }


    /**
     * Mutateur pour la cellule à une ligne/colonne donnée.
     */
    public void setCell(int ligne, int col, double valeur){
        data[ligne][col] = valeur;
    }


    /**
     * Retourne un nouveau vecteur contenant la Nième ligne.
     */
    public Vecteur getLine(int ligne){
        return new Vecteur(data[ligne]) ;
    }


    /**
     * Retourne un nouveau vecteur contenant la Nième colonne.
     */
    public Vecteur getCol(int col){
        double[] colonne = new double[lignes];
        for (int i = 0; i < lignes; i++) {
            colonne[i] = data[i][col];
        } 
        return new Vecteur(colonne);
    }


    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ].
     */
    public void afficher(){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        } 
    }


    /**
     * Retourne une version transposée de la matrice.
     */
    public Matrice transpose(){
        Matrice t = new Matrice(colonnes, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                t.setCell(j, i, data[i][j]);
            }
        }
        return t;
    }


    /**
     * Retourne une instance de la matrice identité N x N.
     */
    public static Matrice identite(int n){
        Matrice identite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            identite.setCell(i, i, 1);
        }
        return identite;
    }


    /**
     * Retourne le nombre de lignes.
     */
    public int getLignes(){
        return lignes;
    }


    /**
     * Retourne le nombre de colonnes.
     */
    public int getColonnes(){
        return colonnes;
    }

}