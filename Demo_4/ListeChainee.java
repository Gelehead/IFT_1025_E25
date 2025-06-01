public class ListeChainee {

    private Noeud premier;

    private class Noeud {
        public int valeur;
        public Noeud prochain;

        public Noeud(int valeur, Noeud prochain) {
            this.valeur = valeur;
            this.prochain = prochain;
        }
    }

    /**
     * Retrouve le idx-ème nœud de la chaîne
     *
     * @param idx indice du nœud
     * @return nœud sélectionné
     */
    public Noeud getNoeud(int idx) {
        Noeud n = this.premier;

        for(int i=0; i<idx; i++) {
            n = n.prochain;
        }

        return n;
    }

    /**
     * Accède au idx-ème élément
     *
     * @param idx indice du nœud
     * @return valeur du nœud
     */
    public int get(int idx) {
        return getNoeud(idx).valeur;
    }

    /**
     * Modifie le idx-ème élément
     *
     * @param idx indice du nœud
     * @param valeur valeur du nœud
     */
    public void set(int idx, int valeur) {
        getNoeud(idx).valeur = valeur;
    }

    /**
     * Calcule la taille de la liste chaînée
     *
     * @return taille de la liste
     */
    public int size() {
        int size = 0;

        Noeud n = this.premier;
        while(n != null) {
            size++;
            n = n.prochain;
        }

        return size;
    }

    /**
     * Ajoute un élément au début de la liste
     *
     * @param valeur valeur du nœud
     */
    public void addFirst(int valeur) {
        this.premier = new Noeud(valeur, this.premier);
    }

    /**
     * Ajoute un élément à la fin de la liste
     *
     * @param valeur valeur du nœud
     */
    public void addLast(int valeur) {
        if(this.premier == null) { // Cas 1 : rien dans la liste
            this.premier = new Noeud(valeur, null);
        } else { // Cas 2 : trouver le nœud final
            Noeud fin = this.premier;
            Noeud n = this.premier.prochain;

            while(n != null) {
                fin = n;
                n = n.prochain;
            }

            // Ajoute un nœud après la fin de la liste
            fin.prochain = new Noeud(valeur, null);
        }
    }

    public void print_iter(){
        Noeud current = this.premier;
        while (true){
            System.out.println(current.valeur);
            if (current.prochain == null) {
                return;
            } else {
                current = current.prochain;
            }
        }
    }

    public void print_rec_init(){
        print_recursif(premier);
    }
    public void print_recursif(Noeud node){
        System.out.println(node.valeur);
        if ( node.prochain == null ) { return ; }
        print_recursif(node.prochain);
    }

    public int size_2(){
        Noeud current = this.premier;
        while (current != null) {

        }
    }
}
