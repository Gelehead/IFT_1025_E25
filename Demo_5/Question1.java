public class Question1 {
    public static int somme(float a, float b) {
        float c = a + b;
        return (int) c;
    }

    public static int max(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        float a = 5.5f;
        float b = 6.6f;
//        System.out.println(somme(b, a));
// *** Affiche :
//        System.out.println(somme(0.2f, 0.2f) + "" + somme(0.2f, 0.2f));
//// *** Affiche :
        int[][] tabs = {{6,6,6},{6,6,6}};
        int[] t1 = tabs[1];
        int[] t2 = {6,6,6};
//        System.out.println(tabs[0] == tabs[0]);
//// *** Affiche :
//        System.out.println(t1 == t2);
//// *** Affiche :
//        System.out.println(tabs[0] == t1);
//// *** Affiche :
//        System.out.println(tabs[1] == t1);
//// *** Affiche :
//        System.out.println(max(tabs[1]));
//// *** Affiche :
        Foo fooTab = new Foo(t1);
//        System.out.println(fooTab.egal(t1));
//// *** Affiche :
//        System.out.println(fooTab.egal(t2));
//// *** Affiche :
        Foo footab2 = new Foo(t2);
        System.out.println(fooTab.egal(footab2));
// *** Affiche :
    }
}
