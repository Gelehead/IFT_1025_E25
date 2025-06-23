// Yousra Bennaceur
// Matricule 20218188
// Date: 1 juin 2025
public class Matrice{

    // Déclaration de l'attribut matrice(ligne et colonnes de la matrice) en private pour respecter l'encapsulation
    private double [] [] matrice;

    // Constructeur pour une matrice de taille Nlignes x Mcolonnes remplie de zéros
    public Matrice(int lignes, int cols){
        this.matrice = new double [lignes] [cols];
    }
    // Additionne la valeur n dans toutes les cellules de la matrice
    public void additionnerScalaire(double n){
        // Boucle imbriquée pour ajouter n à tous les éléments du tableau
        for (int i=0; i<matrice.length; i++) {
            for (int j=0; j<matrice[i].length; j++) {
                matrice [i][j] += n;
            }
        }
    }
    // Multiplie toutes les cellules par un scalaire
    public void multiplierScalaire(double n){
        // Boucle imbriquée pour multiplier n à tous les éléments du tableau
        for (int i=0; i<matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] *= n;
            }
        }
    }
    // Fait le produit matriciel entre deux matrices (en créant une nouvelle matrice)
    public Matrice dotProduct(Matrice m) {
        // Vérifier que nombre de colonnes de la première matrice = nombre de lignes de la deuxième matrice
        if (this.matrice[0].length != m.matrice.length) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        else {
            // Création d'une matrice avec les bonnes dimensions
            Matrice newMatrice = new Matrice(this.matrice.length, m.matrice[0].length);

            // Boucles imbriquées pour faire les multiplications de chaque ligne[i] par chaque colonne[j]
            for (int i = 0; i < this.matrice.length; i++) {
                for (int j = 0; j < m.matrice.length; j++) {
                    // Initialisation de la variable à 0
                    double produitScalaire = 0;
                    // Troisième boucle qui assure que les produits sont additionnés et stockés dans produitScalaire
                    for (int k = 0; k < m.matrice.length; k++) {
                        produitScalaire += this.matrice[i][k] * m.matrice[k][j];
                    }
                    // Mettre le résultat de produitScalaire dans le tableau newMatrice
                    newMatrice.matrice[i][j] = produitScalaire;
                }
            }
            return newMatrice;
        }
    }
    // Accesseur pour la cellule à une ligne/colonne donnée
    public double getCell(int ligne, int col){

        return matrice[ligne][col];
    }
    // Mutateur pour la cellule à une ligne/colonne donnée
    public void setCell(int ligne, int col, double valeur){
        matrice[ligne][col] = valeur;
    }
    // Retourne un nouveau vecteur contenant la Nième ligne
    public Vecteur getLine(int ligne){
        // Création du vecteur (tableau vide)
        double ligneVecteur [] = new double[this.matrice[0].length];
        // Remplir le tableau avec les valeurs de la ligne
        for (int j = 0; j < this.matrice[0].length; j++) {
            ligneVecteur[j]=this.matrice[ligne][j];
        }
        return new Vecteur(ligneVecteur);
    }
    // Retourne un nouveau vecteur contenant la Nième colonne
    public Vecteur getCol(int col){
        // Création du vecteur (tableau vide)
        double[] colVecteur = new double[this.matrice.length];
        // Remplir le tableau avec les valeurs de la colonne
        for (int i = 0; i < this.matrice.length; i++) {
            colVecteur[i] = this.matrice[i][col];
        }
        return new Vecteur(colVecteur);
    }
    // Affiche la matrice sur la console avec chaque ligne entre crochets [ ]
    public void afficher(){
        // Création d'une variable vide
        String contenu = "";
        // Boucle qui affiche chaque ligne entre crochets
        for (int i = 0; i < this.matrice.length; i++) {
            contenu += "[";
            // Boucle qui affiche les valeurs et qui met des virgules après chacune sauf la dernière
            for (int j = 0; j < this.matrice[0].length; j++) {
                contenu += this.matrice[i][j];
                if (j < this.matrice[0].length - 1) {
                    contenu += ", ";
                }
            }
            contenu += "]";
            // Saut de ligne si ce n'est pas la dernière ligne
            if (i < this.matrice.length - 1) {
                contenu += "\n";
            }
        }
        System.out.println(contenu);
    }
    // Retourne une version transposée de la matrice
    public Matrice transpose() {
        // Nouvelle matrice vide
        Matrice matriceTransposee = new Matrice(this.matrice[0].length, this.matrice.length);
        // Boucle qui remplit la matrice transposée
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[0].length; j++) {
                matriceTransposee.matrice[j][i] = this.matrice[i][j];
            }
        }

        return matriceTransposee;
    }
    // Retourne une instance de la matrice identité N x N
    public static Matrice identite(int n){
        // Matrice vide de dimension n
        Matrice identite = new Matrice(n,n);
        // Ajout d'une diagonale de 1 aux positions i,i
        for (int i = 0; i < n; i++) {
            identite.matrice[i][i]=1;

        }
        return identite;
    }

    public int getLignes(){
        return 0;
    }

    public int getColonnes(){
        return 0;
    }

}