public class Reverse {

    public static void printArray(int[] array){
        String arrayString = "{";
        for (int i = 0 ; i < array.length ; i++) {
            arrayString += i != array.length - 1 ? Integer.toString(array[i]) + "," : Integer.toString(array[i]) ;
        }
        System.out.println(arrayString + "}");
    }

    public static int[] renverser_new(int[] tableau) {
        int[] tab = new int[tableau.length];
        for (int i = 0; i < tableau.length; i++) {
            tab[i] = tableau[tableau.length - 1 - i];
        }
        return tab;
    }

    public static int[] renverser_modif(int[] tableau){
        int t;
        for ( int i = 0 ; i < tableau.length / 2 ; i++ ){
            t = tableau[i];
            tableau[i] = tableau[tableau.length - i - 1];
            tableau[tableau.length - i - 1] = t;
        }
        return tableau;
    }

    public static void main(String[] args){
        System.out.println();
        System.out.println("le hon hon");
        
        int[] tableau = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int[] tab2 = renverser_new(tableau);

        printArray(tab2);
        System.out.println(tab2.hashCode());

        int[] tab3 = renverser_modif(tableau);
        
        printArray(tab3);
        System.out.println(tab3.hashCode());

        System.out.println(tableau.hashCode());
    }
}
