import java.io.IOException;

/**
 * Classe qui définit la Vue en ligne de commande. Les méthodes
 * servent simplement à afficher de façon jolie la valeur du compteur.
 */
public class VueConsole {

    public void updateOutput(String text) {
        viderConsole();
        
        for(int i=0; i<text.length() + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println("| " + text + " |");

        for(int i=0; i<text.length() + 4; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("Ajouter: ");
    }

    public void viderConsole() {
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b");
        }
    }
}

