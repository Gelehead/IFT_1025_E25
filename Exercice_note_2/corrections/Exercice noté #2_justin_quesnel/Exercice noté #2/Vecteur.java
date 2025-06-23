public class Vecteur {
    
	// Attribut privé : tableau représentant le vecteur
	private double[] vecteur;
	
	// Constructeur : initialise le vecteur avec un tableau de doubles
    public Vecteur(double[] elements){
		this.vecteur = elements;
    }

    // Fonction qui modifie la valeur à l'indice donné dans le vecteur
    public void setElement(int index, double valeur){
		this.vecteur[index] = valeur;
    }

    // Fonction qui retourne la valeur à l'indice donné dans le vecteur
    public double getElement(int index){
        return this.vecteur[index];
    }

    // Fonction qui calcule le produit scalaire entre ce vecteur et un autre
    public double dotProduct(Vecteur v){
		// Vérifie si les deux vecteurs ont la même longueur
		if(this.vecteur.length != v.longueur()){
			System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN; // Retourne NaN en cas d'erreur de dimension
		}
		else{
			
			double somme = 0;
			for(int i=0; i < this.vecteur.length;i++){
				somme += this.vecteur[i] * v.getElement(i);
			}
			return somme;
		}
    }

    // Fonction pour Redéfinir la méthode toString() pour représenter le vecteur sous forme {x, y, z}
    @Override
    public String toString(){
		
		String msg = "{";
	    for(int i=0; i < this.vecteur.length;i++){
			msg += this.vecteur[i];
			if (i < this.vecteur.length - 1) {
                msg += ", ";
            }
		}
		msg+="}";
        return msg;
    }

    // Fonction pour afficher le vecteur à la console
    public void afficher(){
        System.out.println(this.toString());
    }
	
	// Fonction qui retourne la longueur (taille) du vecteur
	public int longueur(){
		return this.vecteur.length;
	}
}