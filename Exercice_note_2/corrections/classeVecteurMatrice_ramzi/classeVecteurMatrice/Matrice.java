public class Matrice {
    private double[][] matrice;
    private int lignes;
    private int cols;

    /*Procédure qui génère une matrice de m lignes et n colonnes 
     * dont toutes les cellules sont initialisées à 0
    */
    public Matrice(int lignes, int cols) {
        this.lignes = lignes;
        this.cols = cols;
        this.matrice = new double[lignes][cols];
    }

    /*Procédure qui additionne toutes les valeurs contenues
     * dans chaque cellule d'une matrice par un valeur 'n'
      */
    public void additionnerScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                matrice[i][j] += n;
            }
        }
    }
    /*Procédure qui multiplie toutes les cellules d'une
     * matrice par un scalaire 'n'
     */
    public void multiplierScalaire(double n) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                matrice[i][j] *= n;
            }
        }
    }
    /*Fonction qui effectue le produit matriciel entre deux matrices
     * compatibles
    */
    public Matrice dotProduct(Matrice m) {

        /*Vérifie que la matrice m a le même nombre de lignes
        que l'autre a de lignes pour que le produit matriciel soit
        défini */
        if (this.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        /*Crée une nouvelle matrice résultante du même nombre de lignes 
         * la première matrice et du même nombre de colonnes que la deuxième matrice
         * tel que défini dans le produit matriciel
         * ex: une matrice 2x3 multipliée par une matrice 3x2 produira
         * une matrice résultante 2x2
         */
        Matrice produitMatriciel = new Matrice(this.lignes, m.cols);

        /*Boucle qui additionne les produits de chaque éléments des
         * deux matrices à la même postion.
         * i : indique la ligne dans la première matrice
         * j : indique la colonne dans la 2e matrice
         * k: indique la colonne dans la première matrice
         */
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < m.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.matrice[i][k] * m.matrice[k][j];
                }
                /*place le résultat dans chaque cellule de la matrice résultante */
                produitMatriciel.setCell(i, j, sum);
            }
        }
        return produitMatriciel;
    }

    /*Fonction qui retourne la valeur d'une cellule à la position spécifiée*/
    public double getCell(int ligne, int col) {
        return matrice[ligne][col];
    }
    /*Procédure qui place une nouvelle valeur dans la cellule spécifiée */
    public void setCell(int ligne, int col, double valeur) {
        matrice[ligne][col] = valeur;
    }
    /*Fonction qui retourne un nouveau vecteur ligne correspondant à la nième ligne d'une matrice  */
    public Vecteur getLine(int ligne) {
        double[] Nligne = new double[cols];

        /*Boucle qui place chaque élément d'une ligne d'une matrice dans un vecteur ligne */
        for (int j = 0; j < cols; j++) {
            Nligne[j] = matrice[ligne][j];
        }
        return new Vecteur(Nligne);
    }

     /*Fonction retourne le nombre de lignes d'une matrice*/
     public int getLignes() {
        return this.lignes;
    }
     /*Fonction qui retourne un nouveau vecteur colonne correspondant à la nième colonne d'une matrice  */
    public Vecteur getCol(int col) {
        double[] Ncol = new double[lignes];

         /*Boucle qui place chaque élément d'une colonne d'une matrice dans un vecteur colonne */
        for (int i = 0; i < lignes; i++) {
            Ncol[i] = matrice[i][col];
        }
        return new Vecteur(Ncol);
    }

     /*Fonction retourne le nombre de colonnes d'une matrice*/
    public int getColonnes() {
        return this.cols;
    }
    /*Procédure qui affiche une matrice */
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ "); 
            for (int j = 0; j < cols; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println("]");
        }
    }
    /*Fonction qui retourne la transposée d'une matrice en interchangeant les
     * lignes par les colonnes d'une matrice et vice-versa
     */
    public Matrice transpose() {
        Matrice matriceTranspose = new Matrice(this.cols, this.lignes);

        /*Boucle qui place la valeur dans la cellule (i,j) à la cellule (j,i)*/
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.cols; j++) {
                matriceTranspose.setCell(j, i, this.matrice[i][j]);
            }
        }
        return matriceTranspose;
    }
    /*Fonction qui génère une matrice identité (une matrice avec des 1 dans sa diagonale
     * et des 0 dans les autres positions) */
    public static Matrice identite(int n) {
        Matrice matriceIdentite = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            matriceIdentite.setCell(i, i, 1.0);
        }
        return matriceIdentite;
    }

}
