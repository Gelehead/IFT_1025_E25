import java.util.ArrayList;
import java.util.LinkedList;

public class Dictionnaire extends Livre{
    private ArrayList<Paire<String, String>> definitions;

    public Dictionnaire(String titre, int nbPages, int prixReg, int rabais) {
        super(titre, nbPages, prixReg, rabais);
        this.definitions = new ArrayList<>();
    }

    public Paire<String, String> getPaire(String mot){
        for ( Paire<String, String> p : definitions ) {
            if ( p.getX().equals(mot)) {
                return p;
            }
        }
        return null;
    }
    public String getDefinition(String mot) {
        return getPaire(mot).getY();
    }
    public String getDefinition(int index) {
        return definitions.get(index).getY();
    }

    public void setDefinitions(String mot, String definition) {
        Paire<String, String> paire = getPaire(mot);
        if ( paire == null ) {
            definitions.add(new Paire<String, String>(mot, definition));
        } else {
            paire.setY(definition);
        }
    }

    public ArrayList<Paire<String, String>> getAllDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + definitions.size();
    }

}


















