import java.util.Arrays;

public class Matrice {
    private double[][] matrice;

    private int lignes;
    private int cols;

    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.cols = cols;

        //creer matrice
        creerMatrice(getLignes(), getColonnes());
    }

    
    /** 
     * @param lignes
     * @param cols
     * @return double[][]
     */
    public double[][] creerMatrice(int lignes, int cols) {
        if(lignes <= 0 || cols <= 0){
            System.out.println("Nombres de lignes ou colonnes invalide"); 
        }else{
            matrice = new double[lignes][cols];

            for(int i = 0; i < lignes; i++) {
                for(int j = 0; j < cols; j++) {
                    matrice[i][j] = 0;
                }
            }
        }
        return matrice;

    }
    
    /** 
     * @param n
     */
    //Additionne la valeur n dans toutes les cellules de la matrice (modifie la matice actuelle)
    //Exemple : matrice = [[1,2],[3,4]] et n = 2 => matrice = [[3,4],[5,6]]
    public void additionnerScalaire(double n) {
        for(int i = 0; i < lignes; i++) {
            for(int j = 0; j < cols; j++) {
                matrice[i][j] += n;
            }
        }
    }

    
    /** 
     * @param n
     */
    //Multiplie toutes les cellules par un scalaire
    //(modifie la matrice actuelle)
    public void multiplierScalaire(double n) {
        for(int i = 0; i < lignes; i++) {
            for(int j = 0; j < cols; j++) {
                matrice[i][j] *= n;
            }
        }
    }

    
    /** 
     * @param m
     * @return Matrice
     */
    /*   * dotProduct d'une Matrice
      => Si les dimensions des matrice multipliées ne sont pas
         cohérentes, exécutez ce code :

            System.err.println("Erreur dans les dimensions des matrices");
            return null; 
            
            dot product: taille de la grille finale = (M x N) X (N x P) = M x P
            */
    public Matrice dotProduct(Matrice m) {
        double result;
        
        Matrice nouvelleMatrice = new Matrice(lignes, m.cols);
        if(this.cols != m.getLignes()){
            //System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }else{
            // Calcul du produit matriciel
            // C[i][j] = Somme(A[i][k] * B[k][j]) pour k allant de 0 à this.cols - 1
            for (int i = 0; i < this.lignes; i++) { // Pour chaque ligne de la matrice A (et de nouvelleMatrice)
                for (int j = 0; j < m.getColonnes(); j++) { // Pour chaque colonne de la matrice B (et de nouvelleMatrice)
                    double sum = 0.0;
                    for (int k = 0; k < this.cols; k++) { // k correspond à la dimension commune (colonnes de A, lignes de B)
                        // this.matrice[i][k] pour accéder aux éléments de la matrice actuelle (A)
                        // m.getCell(k, j) pour accéder aux éléments de la matrice m (B)
                        sum += this.matrice[i][k] * m.getCell(k, j);
                    }
                    nouvelleMatrice.setCell(i, j, sum); // Assigne la valeur calculée à la cellule de la nouvelle matrice
                }
            }
        }
        return this;

    }

    
    /** 
     * @param ligne
     * @param col
     * @return double
     */
    /*getCell/setCell/... toutes les fonctions qui accèdent à des index
      => Si l'index dépasse les bornes de la matrice ou du vecteur
       > Ne gérez pas l'erreur, laissez le programme planter à l'exécution */
    public double getCell(int ligne, int col) {
        return matrice[ligne][col];
    }
    
    /** 
     * @param ligne
     * @param col
     * @param valeur
     */
    public void setCell(int ligne, int col, double valeur) {
        matrice[ligne][col] = valeur;
    }

    
    /** 
     * @param ligne
     * @return Vecteur
     */
    //Retourne un nouveau vecteur contenant la Nième ligne

    public Vecteur getLine(int ligne) {
        Vecteur v = new Vecteur(matrice[ligne]);
        return v;
    }
    
    /** 
     * @param col
     * @return Vecteur
     */
    //Retourne un nouveau vecteur contenant la Nième colonne
    //iterer a travers la matrice et sauvegarde les elements [i][j]
    public Vecteur getCol(int col) {
        double elementCols[] = new double[lignes];
        for (int i = 0; i < matrice.length; i++) {
            elementCols[i] = matrice[i][col];
        }
        Vecteur v = new Vecteur(elementCols); // Assuming Vecteur has a constructor that takes a double[]
        return v;
    }

    
    /** 
     * @return Matrice
     */
    //MxN = NxM SANS MODIFIER LA MATRICE ACTUELLE (COPIE)
    public Matrice transpose() {
        Matrice matriceTransposee = new Matrice(cols, lignes);
        for(int i = 0; i < lignes; i++) {
                for(int j = 0; j < cols; j++) {
                    matriceTransposee.setCell(j, i, matrice[i][j]);
                }
        }
        return matriceTransposee;
    }


    
    /** 
     * @param n
     * @return Matrice
     */
    //Renvoie une matrice identité de taille NxN
    //Exemple : matrice = [[1,0],[0,1]] pour N = 2
    public static Matrice identite(int n) {
        Matrice matriceIdentite = new Matrice(n, n);

        for(int i = 0; i < n; i++) {
            matriceIdentite.setCell(i, i, 1);
        }
        return matriceIdentite;
    }

    public void afficher() {
        String line = "";
        for(int i = 0; i < lignes; i++) {
            line += "[ ";
            for(int j = 0; j < cols; j++) {
                line += matrice[i][j] + " ";
            }
            line += "]\n";
        }
        System.out.print(line);
    }

    
    /** 
     * @return String
     */
    public String toString() {
        String line = "";
        for(int i = 0; i < lignes; i++) {
            line += "[";
            for(int j = 0; j < cols; j++) {
                line += matrice[i][j] + " ";
            }
            line += "]\n";
        }
        return line;
    }
    
    
    /** 
     * @return int
     */
    //GETTERS AND SETTERS
    public int getLignes() {
        return lignes;
    }
    
    /** 
     * @param lignes
     */
    public void setLignes(int lignes) {
        this.lignes = lignes;
    }

    
    /** 
     * @return int
     */
    public int getColonnes() {
        return cols;
    }
    
    /** 
     * @param cols
     */
    public void setCols(int cols) {
        this.cols = cols;
    }
}