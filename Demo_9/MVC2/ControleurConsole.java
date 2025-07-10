
/**
 * Le contrôleur est en charge de demander au modèle de faire les
 * modifications appropriées lorsque nécessaire et peut demander à la
 * vue de se mettre à jour lorsque le modèle est modifié.
 */
public class ControleurConsole {

    // Classe qui sert uniquement à l'affichage
    private VueConsole vue;

    // Le modèle de l'application est simplement une instance de Compteur
    private Compteur modele;

    ControleurConsole() {
        this.vue = new VueConsole();
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
