public class Matrice{
    private final int lignes; // Nombre de lignes de la matrice
    private final int colonnes; // Nombre de colonnes de la matrice
    private final double[][] elements; // Tableau des éléments de la matrice
    public Matrice(int lignes, int cols){
        this.lignes = lignes;
        this.colonnes = cols;
        this.elements = new double[lignes][cols]; // Initialisation du tableau avec des zéros
    }
    
    /*
     * Additionne la valeur n dans toutes les cellules de la matrice
     * (modifie la matrice actuelle)
     */
    public void additionnerScalaire(double n){
        for (double[] ligne : elements) {
            for (int j = 0; j < ligne.length; j++) {
                ligne[j] += n; // Ajoute n à chaque élément de la ligne
            }
        }
    }

    /**
     * @param n le scalaire avec lequel on veut multiplier la matrice
     */
    public void multiplierScalaire(double n){
        for (double[] ligne : elements) {
            for (int j = 0; j < ligne.length; j++) {
                ligne[j] *= n; // Multiplie chaque élément de la ligne par n
            }
        }
    }
    /*
    *
     * Fait le produit matriciel entre deux matrices
     * @return (crée une *nouvelle matrice* de la bonne taille, ne modifie
     * pas les deux matrices originales)
     */
    public Matrice dotProduct(Matrice m){ 
       //on vérifie les dimensions
       if (this.colonnes != m.lignes) {
           System.err.println("Erreur dans les dimensions des matrices");
           return null; // Retourne null si les dimensions ne sont pas compatibles
       }
         Matrice resultat = new Matrice(this.lignes, m.colonnes); // Création d'une nouvelle matrice pour le résultat
         for (int i = 0; i < this.lignes; i++) {
             Vecteur ligne = this.getLine(i); // Récupère la ligne i de la matrice actuelle
                for (int j = 0; j < m.colonnes; j++) {
                    Vecteur col = m.getCol(j); // Récupère la colonne j de la matrice m
                    double produitScalaire = ligne.dotProduct(col); // Calcule le produit scalaire entre la ligne et la colonne
                    resultat.setCell(i, j, produitScalaire); // Stocke le résultat dans la nouvelle matrice
                } 
            }
        return resultat; 
    }
    /**
     * @param ligne
     * @param col
     * @return valeur contenue dans la cellule
     */
    public double getCell(int ligne, int col){
        return elements[ligne][col]; // Retourne l'élément à la position (ligne, col)
    }

    
    /**
     * @param ligne
     * @param col
     * @param valeur
     */
    public void setCell(int ligne, int col, double valeur){
       
        elements[ligne][col] = valeur; // Modifie l'élément à la position (ligne, col)
    }

    /**
     * @param ligne
     * @return un vecteur contenant les éléments de la ligne
     */
    public Vecteur getLine(int ligne){
        return new Vecteur(elements[ligne]); 
    }

    /**
     * @param col
     * @return un vecteur contenant les éléments de la colonne
     */
    public Vecteur getCol(int col){
        double[] colonne = new double[lignes]; // Crée un tableau pour stocker la colonne
        for (int i = 0; i < lignes; i++) {
            colonne[i] = elements[i][col]; // Remplit le tableau avec les éléments de la colonne
        }
        return new Vecteur(colonne);
    }
    
    /*
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     * 
     * Par exemple, la matrice qui contient les nombres 1 et 2 sur la
     * première ligne et 13 et 14 sur la deuxième ligne sera affichée
     * avec :
     * 
     * [ 1.0 2.0 ]
     * [ 13.0 14.0 ]
     */
    public void afficher(){
        String retour = "";
        for (double[] ligne : elements) {
            String ligneStr = "[ ";
            for (int j = 0; j < ligne.length; j++) {
                ligneStr += ligne[j]; // Ajoute chaque élément de la ligne
                if (j < ligne.length - 1) {
                    ligneStr += " "; // Ajoute un espace entre les éléments
                }
            }
            ligneStr += " ]"; // Ferme la ligne avec ]
            retour += ligneStr + "\n"; // Ajoute la ligne à la chaîne de retour
        }
        System.out.print(retour); // Affiche la matrice formatée
    }

    /**
     * @return la transposée de la matrice
     */
    public Matrice transpose(){
        Matrice transposee = new Matrice(this.colonnes, this.lignes); // Crée une nouvelle matrice transposée
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                transposee.setCell(j, i, this.getCell(i, j)); // Inverse les indices pour la transposition
            }
        }
        return transposee; // Retourne la matrice transposée
    }

    /**
     * @param n
     * @return la matrice identité de taille n x n
     */
    public static Matrice identite(int n){
        Matrice identite = new Matrice(n, n); // Crée une matrice n x n
        for (int i = 0; i < n; i++) {
            identite.setCell(i, i, 1.0); // Met 1 sur la diagonale principale
        }
        return identite; // Retourne la matrice identité
    }

    /**
     * @return le nombre de lignes de la matrice
     */
    public int getLignes(){
        return lignes; // Retourne le nombre de lignes de la matrice
    }

    /**
     * @return le nombre de colonnes de la matrice
     */
    public int getColonnes(){
        return colonnes; // Retourne le nombre de colonnes de la matrice
    }

}