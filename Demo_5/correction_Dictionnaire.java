import java.util.ArrayList;

public class correction_Dictionnaire extends correction_Livre {
    private ArrayList<Paire<String, String>> definitions;

    public correction_Dictionnaire(String titre, int nbpages, int prixReg, int rabais){
        super(titre, nbpages, prixReg, rabais);
        definitions = new ArrayList<>();
    }

    private Paire<String, String> getMot(String mot) {
        for (Paire<String, String> p : definitions) {
            if (p.getX().equals(mot)) {
                return p;
            }
        }
        return null;
    }

    public String getDefinition(String mot) {
        return getMot(mot) == null ? "" : getMot(mot).getY();
    }
    public void setDefinition(String mot, String definition) {
        Paire<String, String> paire = getMot(mot);
        if ( paire == null ) {
            definitions.add(new Paire<String, String>(mot, definition));
        } else {
            paire.setY(definition);
        }
    }
    public ArrayList<Paire<String, String>> getAllDefinitions() {
        return definitions;
    }

    public void setAllDefinitions(ArrayList<Paire<String, String>> definitions) {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.definitions.size();
    }
}
