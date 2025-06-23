public class Matrice{
    
	// Attribut privé : tableau 2D représentant la matrice
	private double[][] matrice;
	
	 // Constructeur : initialise une matrice de dimensions données 
	 // (lignes x colonnes) remplie de 0.0
    public Matrice(int lignes, int cols){
		this.matrice = new double[lignes][cols];
    }

    // Fonction qui ajoute un scalaire 'n' à chaque élément de la matrice
    public void additionnerScalaire(double n){
        for(int i=0; i< this.matrice.length;i++){
			for(int j=0; j< this.matrice[0].length;j++){
				this.matrice[i][j]+= n;
			}
		}
    }

    // Fonction qui multiplie chaque élément de la matrice par un scalaire 'n'
    public void multiplierScalaire(double n){
        for(int i=0; i< this.matrice.length;i++){
			for(int j=0; j< this.matrice[0].length;j++){
				this.matrice[i][j]*= n;
			}
		}
    }
    
	// Produit matriciel entre cette matrice et la matrice m 
    public Matrice dotProduct(Matrice m){
		
		// Vérifie la compatibilité des dimensions : si le nombres de colonnes 
		// de cette matrice est égales aux nombres de lignes de la matrice m
		if(this.matrice[0].length != m.getLignes()){
			System.err.println("Erreur dans les dimensions des matrices");
            return null;
		}
		else{
			// Création de la matrice dotProduct de taille [lignes de cette matrice] x [colonnes de m]
			Matrice matriceDP = new Matrice(this.matrice.length, m.getColonnes());
			
			// Calcul du produit matriciel 
			for (int i = 0; i < this.matrice.length; i++) {
				for (int j = 0; j < m.getColonnes(); j++) {
					for (int k = 0; k < this.matrice[0].length; k++) {
                        matriceDP.setCell(i,j, matriceDP.getCell(i,j)+ this.matrice[i][k] * m.getCell(k,j));
                    }
				}
            }
			return matriceDP;
		}
    }

    // Fonction qui retourne la valeur de la cellule à la position (ligne, colonne)
    public double getCell(int ligne, int col){
        return matrice[ligne][col];
    }

    // Fonction qui remplace une valeur à la cellule existante à la position (ligne, colonne)
    public void setCell(int ligne, int col, double valeur){
		matrice[ligne][col] = valeur;
    }

    // Fonction qui retourne un vecteur correspondant à une ligne spécifique de la matrice
    public Vecteur getLine(int ligne){
        return new Vecteur(this.matrice[ligne]);
    }

    // Fonction qui retourne un vecteur correspondant à une colonne spécifique de la matrice
    public Vecteur getCol(int col){
		double[] colonne = new double[this.matrice.length];
		for(int i=0; i<this.matrice.length;i++){
			colonne[i]= this.matrice[i][col];
		}
        return new Vecteur(colonne);
    }

    // Fonction qui affiche la matrice ligne par ligne avec un format [x y z]
    public void afficher(){
        for(int i=0; i< this.matrice.length;i++){
			System.out.print("[");
			for(int j=0; j< this.matrice[0].length;j++){
				System.out.print(this.matrice[i][j]);
                if (j < this.matrice[0].length - 1) {
                    System.out.print(" ");
                }
			}
		    System.out.println("]");
		}
    }

    // Fonction qui retourne la transposée de la matrice courante (échange lignes et colonnes)
    public Matrice transpose(){
		Matrice matriceT = new Matrice(this.matrice[0].length, this.matrice.length);
		
		for(int i=0; i< this.matrice.length;i++){
			for(int j=0; j< this.matrice[0].length;j++){
				matriceT.setCell(j, i , this.matrice[i][j]);
			}
		}
        return matriceT;
    }

    // Fonction qui génère et retourne une matrice identité de taille n x n
    public static Matrice identite(int n){
        Matrice matriceI = new Matrice(n, n);
		
		for(int i=0; i< matriceI.getLignes();i++){
			for(int j=0; j< matriceI.getColonnes();j++){
				if(i == j ){
					matriceI.setCell(i, j , 1.0);
				}
			}
		}
        return matriceI;
    }

    // Fonction qui retourne le nombre de lignes de la matrice
    public int getLignes(){
        return this.matrice.length;
    }

    // Fonction qui retourne le nombre de colonnes de la matrice
    public int getColonnes(){
        return this.matrice[0].length;
    }

}