/**
 * Une Matrice est un tableau bidimensionnel de nombres de type 'double'.
 * La 1re dimension du tableau correspond aux lignes de la matrice, la 2e
 * à ses colonnes.
 *
 * @author     Thomas Ring, matricule 20162157.
 * @since      1er juin 2025
 */

public class Matrice{

    /**
     * Nombre de lignes de la matrice.
     */
    private int nbLignes;

    /**
     * Nombre de colonnes de la matrice.
     */
    private int nbColonnes;

    /**
     * Tableau de tableaux contenant les éléments de la matrice.
     */
    private double[][] elements;


    /**
     * Constructeur pour une matrice de taille 'nbLignes' lignes x 'nbColonnes'
     * colonnes remplie de zeros.
     *
     * @param nbLignes    int : nombre de lignes de la matrice.
     * @param nbColonnes  int : nombre de colonnes de la matrice.
     */
    public Matrice(int nbLignes, int nbColonnes){
        this.elements = new double[nbLignes][nbColonnes];
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
    }


    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     * (modifie la matrice actuelle).
     *
     * @param n    double : quantité à ajouter à chaque cellule de la matrice.
     */
    public void additionnerScalaire(double n){
        for(int i = 0; i < this.getNbLignes(); i++){

            for(int j = 0; j < this.getNbColonnes(); j++){

                this.elements[i][j] += n;
            }
        }
    }


    /**
     * Multiplie toutes les cellules par un scalaire
     * (modifie la matrice actuelle).
     *
     * @param n    double : quantité de laquelle multiplier chaque cellule de la
     *             matrice.
     */
    public void multiplierScalaire(double n){
        for(int i = 0; i < this.getNbLignes(); i++){

            for(int j = 0; j < this.getNbColonnes(); j++){

                this.elements[i][j] *= n;
            }
        }
    }

    /**
     * Fait le produit matriciel entre deux matrices
     * (crée une *nouvelle matrice* de la bonne taille, ne modifie
     * pas les deux matrices originales).
     * La matrice sur laquelle la méthode est appelée est la matrice de gauche,
     * et la matrice passée en argument est la matrice de droite.
     * La matrice de gauche doit avoir autant de colonnes que la matrice de
     * droite a de lignes.
     *
     * @param m     Matrice de droite du produit matriciel.
     * @return      La nouvelle matrice qui résulte du produit matriciel.
     *              Elle a autant de lignes que la matrice de gauche et autant
     *              de colonnes que la matrice de droite.
     */
    public Matrice dotProduct(Matrice m){
        if (this.getNbColonnes() != m.getNbLignes()){
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice resultat = new Matrice(this.getNbLignes(), m.getNbColonnes());
        for(int i = 0; i < resultat.getNbLignes(); i++) {

            for (int j = 0; j < resultat.getNbColonnes(); j++) {

                resultat.setCell(i, j, this.getLine(i).dotProduct(m.getCol(j)));
            }
        }
        return resultat;
    }


    /**
     * Accesseur pour la cellule à une ligne/colonne donnée.
     * @param ligne      int : indice de la ligne de la cellule accédée.
     * @param colonne    int : indice de la colonne de la cellule accédée.
     * @return           Le 'double' se trouvant à la cellule accédée.
     */
    public double getCell(int ligne, int colonne){
        return this.elements[ligne][colonne];
    }


    /**
     * Mutateur pour la cellule à une ligne/colonne donnée.
     * @param ligne      int : indice de la ligne de la cellule mutée.
     * @param colonne    int : indice de la colonne de la cellule mutée.
     * @param valeur     Le 'double' assigné à la cellule mutée.
     */
    public void setCell(int ligne, int colonne, double valeur){
        this.elements[ligne][colonne] = valeur;
    }


    /**
     * Accesseur pour la 'ligne'-ième ligne.
     * @param ligne       int : indice de la ligne accédée.
     * @return            Vecteur : une copie de la ligne accédée.
     * @see Vecteur
     */
    public Vecteur getLine(int ligne){
        return new Vecteur(this.elements[ligne]);
    }


    /**
     * Accesseur pour la 'colonne'-ième colonne.
     * @param colonne     int : indice de la colonne accédée.
     * @return            Vecteur : une copie de la colonne accédée.
     * @see Vecteur
     */
    public Vecteur getCol(int colonne){
        double[] colonneAccedee = new double[this.getNbLignes()];

        for(int i = 0; i < this.getNbLignes(); i++){
            colonneAccedee[i] = this.elements[i][colonne];
        }

        return new Vecteur(colonneAccedee);
    }


    /**
     * Affiche la matrice sur la console, chaque ligne entre crochets [ ]
     * Par exemple, la matrice qui contient les nombres 1 et 2 sur la
     * première ligne et 13 et 14 sur la deuxième ligne sera affichée avec :
     * [ 1.0 2.0 ]
     * [ 13.0 14.0 ]
     */
    public void afficher(){
        String matriceAffichee = "";

        for(int i = 0; i < this.getNbLignes(); i++){
            // Inscrit le premier caractère d'une ligne.
            matriceAffichee += "[ ";

            // Remplit une ligne.
            for(int j = 0; j < this.getNbColonnes(); j++){
                matriceAffichee += this.elements[i][j] + " ";
            }

            // Termine une ligne et en commence une nouvelle.
            matriceAffichee += "]\n";
        }
        System.out.println(matriceAffichee);
    }


    /**
     * Retourne une version transposée de la matrice
     * (sans modifier la matrice actuelle).
     * @return  Une version transposée de la matrice.
     */
    public Matrice transpose(){
        Matrice transposee = new Matrice(this.getNbColonnes(),
                this.getNbLignes());

        for(int i = 0; i < transposee.getNbLignes(); i++){

            for(int j = 0; j < transposee.getNbColonnes(); j++){
                transposee.setCell(i, j, this.getCell(j, i));
            }
        }
        return transposee;
    }


    /**
     * Retourne une instance de la matrice identité n x n.
     * @param n     int : taille de la matrice identité retournée.
     * @return      Matrice identité n x n.
     */
    public static Matrice identite(int n){
        Matrice id = new Matrice(n, n);

        for(int i = 0; i < n; i++){
            id.setCell(i, i, 1);
        }

        return id;
    }

    /**
     * Accesseur pour le nombre de lignes de la matrice.
     * @return       int : nombre de lignes de la matrice.
     */
    public int getNbLignes(){
        return this.nbLignes;
    }

    /**
     * Accesseur pour le nombre de colonnes de la matrice.
     * @return        int : nombre de colonnes de la matrice.
     */
    public int getNbColonnes(){
        return this.nbColonnes;
    }

}