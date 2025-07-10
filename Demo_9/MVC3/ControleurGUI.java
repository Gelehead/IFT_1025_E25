import src.main.java.VueGUI;

/**
 * Même classe que dans le programme MVC1
 */
public class ControleurGUI {

    // La vue est le point d'entrée de l'Application JavaFX
    private VueGUI vue;

    // Le modèle de l'application est simplement une instance de Compteur
    private Compteur modele;

    ControleurGUI(VueGUI vue) {
        this.vue = vue;
        this.modele = new Compteur();

        vue.updateOutput("" + modele.getValeur());
    }

    public void ajouter(String text) {
        try {
            double nombre = Double.parseDouble(text);

            modele.ajouter(nombre);

            vue.updateOutput("" + modele.getValeur());

        } catch (NumberFormatException exception) {
            vue.updateOutput("Erreur");
            modele = new Compteur();
        }
    }
}
