import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> liste = new ArrayList<>();
        ListeChainee listeChainee = new ListeChainee();
        LinkedList<Integer> linkedList = new LinkedList<>();

        listeChainee.addFirst(5);
        listeChainee.addFirst(4);
        listeChainee.addFirst(3);
        listeChainee.addFirst(2);
        listeChainee.addFirst(1);

        listeChainee.print_iter();
        System.out.println(listeChainee.size());
    }
    
}
