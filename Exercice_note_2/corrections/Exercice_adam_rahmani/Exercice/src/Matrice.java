/**
 * @author Adam Rahmani
 * @version exercice note 2
 * matricule: 20186680
 * Date : 2025-05-30
 *
 * Class Matrice qui nous permet de faire des manipulations
 * dans la Matrice
 */

public class Matrice{
    private double matrice[][];

    /**
     *Retourne le nombre de lignes
     *
     * @return Nombre de lignes
     */
    public int getLine(){
        return matrice.length;
    }

    /**
     * Retourne le nombre de colonnes
     *
     * @return Nombre de colonnes
     */
    public int getCol(){
        return matrice[0].length;
    }

    /**
     * Cette méthode permet de retourner un element precis dans la matrice
     *
     * @param i
     * @param j
     * @return element[i][j]
     */
    public double getElement(int i, int j) {
        return matrice[i][j];
    }

    /**
     * Constructeur pour une matrice de taille Nlignes x Mcolonnes
     * remplie de zéros
     *
     * @param lignes le nombre de lignes de la matrice
     * @param cols le nombre de colonnes
     */
    public Matrice(int lignes, int cols){
        matrice = new double[lignes][cols];
    }

    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     *
     * @param n le chiffre qu'on va additionner
     */
    public void additionnerScalaire(double n){
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[0].length; j++){
                this.matrice[i][j] = n + matrice[i][j];
            }
        }
    }

    /**
     * Multiplie toutes les cellules par un scalaire
     *
     * @param n le chiffre qu'on va multiplier
     */
    public void multiplierScalaire(double n){
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[0].length; j++){
                this.matrice[i][j] = n * matrice[i][j];
            }
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices
     *
     * @param m la matrice qu'on va multiplier
     * @return resultat la nouvelle matrice contenant le resultat
     */
    public Matrice dotProduct(Matrice m){

        int nbLignesMatrice1 = this.getLine();
        int nbColonneMatrice1 = this.getCol();
        int nbLignesMatrice2 = m.getLine();
        int nbColonneMatrice2 = m.getCol();

        // Le nombre de colonne N dois etre egale au nb lignes de M (N*M)
        if (nbColonneMatrice1 != nbLignesMatrice2){
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice resultat = new Matrice(nbLignesMatrice1, nbColonneMatrice2);
        for(int i = 0; i < nbLignesMatrice1; i++){
            for(int j = 0; j < nbColonneMatrice2; j++ ){
                double somme = 0;
                for(int k = 0; k < nbColonneMatrice1; k++){
                    somme += this.matrice[i][k] * m.getElement(k, j);
                }
                resultat.setCell(i, j, somme);
            }
        }
        return resultat;
    }

    /**
     * Accesseur pour la cellule à une ligne/colonne donnée
     *
     * @param ligne coordonne ligne
     * @param col coordonne colonne
     * @return la valeur contenu dans [ligne][col]
     */
    public double getCell(int ligne, int col){
        return this.matrice[ligne][col];
    }

    /**
     * Cette méthode joue le role de modificateur pour une cellule a une ligne/colonne
     * donnee
     * @param ligne coordonne ligne
     * @param col coordonne cologne
     * @param valeur la valeur qu'on veut assigner
     */
    public void setCell(int ligne, int col, double valeur){
        this.matrice[ligne][col] = valeur;
    }

    /**
     * Cette méthode nous permet de retourner une ligne precise sous la forme
     * d'un vecteur
     *
     * @param ligne coordonne ligne
     * @return valeurs
     */
    public Vecteur getLine(int ligne){
        int nbCol = this.getCol();
        double[] valeurs = new double[nbCol];
        for(int i = 0; i < nbCol; i++ ){
            valeurs[i] = this.matrice[ligne][i];
        }
        return new Vecteur(valeurs);
    }

    /**
     * Cette méthode nous permet de retourner une colonne precise sous la forme
     * d'un vecteur
     * @param col coordonne cologne
     * @return valeurs nouveau vecteur contenant les valeurs
     */
    public Vecteur getCol(int col){
        int nbligne = this.getLine();
        double[] valeurs = new double[nbligne];
        for(int i = 0; i < nbligne; i++ ){
            valeurs[i] = this.matrice[i][col];
        }
        return new Vecteur(valeurs);
    }

    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     */
    public void afficher(){

        int nbLignes = this.getLine();
        int nbCol = this.getCol();

        for(int i = 0; i < nbLignes; i++){
            System.out.print("[ ");
            for(int j = 0; j < nbCol; j++){
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Retourne une version transposée de la matrice
     * @return transpose retourne la nouvelle matrice transpose
     */
    public Matrice transpose(){
        int nbLignes = this.getLine();
        int nbCol = this.getCol();
        Matrice transpose = new Matrice(nbCol, nbLignes);

        for(int i = 0; i < nbLignes; i++){
            for(int j = 0; j < nbCol; j++){
                transpose.matrice[j][i] = this.matrice[i][j];
            }
        }
        return transpose;
    }

    /**
     * Retourne une instance de la matrice identité N x N
     * @param n la taille de la matrice n*n
     * @return identiteM une instance de la matrice
     */
    public static Matrice identite(int n){
        Matrice identiteM  = new Matrice(n, n);

        for(int k = 0; k < n; k++ ){
            identiteM.setCell(k, k, 1);
        }
        return identiteM;
    }
}
