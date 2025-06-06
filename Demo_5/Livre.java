public abstract class Livre {
    private String titre;
    private int nbPage, prixReg, rabais;
    public Livre( String titre, int nbpages, int prixReg, int rabais) {
        this.titre = titre;
        this.nbPage = nbpages;
        if ( rabais < 0 ) {
            this.rabais = 0;
        } else if (rabais > 100) {
            this.rabais = 100;
        } else {
            this.rabais = rabais;
        }

        this.prixReg = prixReg;
    }

    protected int prixVente() {
        return this.prixReg * (100 - this.rabais)/100;
    }

    @Override
    public String toString() {
        return this.titre + " - " + this.nbPage + this.prixVente() / 100 + "." + this.prixVente() % 100 + "$";
    }

    public String getTitre() {
        return titre;
    }

    public int getRabais() {
        return rabais;
    }

    public int getNbPage() {
        return nbPage;
    }

    public int getPrixReg() {
        return prixReg;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setRabais(int rabais) {
        this.rabais = rabais;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public void setPrixReg(int prixReg) {
        this.prixReg = prixReg;
    }
}

