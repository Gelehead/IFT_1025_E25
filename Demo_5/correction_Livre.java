public abstract class correction_Livre {

    private String titre;
    private int page_number;
    private int prix_reg;
    private int rabais;

    public correction_Livre(String titre, int page_number, int prix_reg, int rabais) {
        this.titre = titre;
        this.page_number = page_number;
        if (rabais < 0 ) { this.rabais = 0; }
        else {
            if ( rabais > 100 ) {this.rabais = 100;}
            else this.rabais = rabais;
        }
        this.prix_reg = prix_reg;
    }

    public int prix_vente() {
        return this.prix_reg * (100 - rabais)/100;
    }

    @Override
    public String toString() {
        return this.titre + " - " + this.page_number + " - " + this.prix_vente() / 100 + "" +this.prix_vente()%100 + "$";
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public void setPrix_reg(int prix_reg) {
        this.prix_reg = prix_reg;
    }

    public void setRabais(int rabais) {
        this.rabais = rabais;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPage_number() {
        return page_number;
    }
    public int getPrix_reg() {
        return prix_reg;
    }
    public int getRabais() {
        return rabais;
    }
    public String getTitre() {
        return titre;
    }
}

