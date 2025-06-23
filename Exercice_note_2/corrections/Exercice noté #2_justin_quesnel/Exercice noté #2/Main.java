public class Main {
    public static void main(String[] args) {
        // Tests publics
        int passed_tests = 0;
        
        // vecteurs
        if ( Test.vec_dot() ) {
            passed_tests += 1;
        }
        if ( Test.vec_get() ) {
            passed_tests += 1;
        }
        if ( Test.vec_rep() ) {
            passed_tests += 1;
        }
        if ( Test.vec_set() ) {
            passed_tests += 1;
        }
        if ( Test.vec_getelement_oob() ) {
            passed_tests += 1;
        }
        
        // Matrice
        if (Test.mat_dot_bad_dim()) {
            passed_tests += 1;
        }
        if (Test.mat_setget()) {
            passed_tests += 1;
        }
        if (Test.mat_addscalaire()) {
            passed_tests += 1;
        }
        if (Test.mat_multscalaire()) {
            passed_tests += 1;
        }
        if (Test.mat_transpose()) {
            passed_tests += 1;
        }
        if (Test.mat_identite()) {
            passed_tests += 1;
        }
        if (Test.mat_getcell_oob()) {
            passed_tests += 1;
        }
        
        System.out.println(passed_tests);
    }
}