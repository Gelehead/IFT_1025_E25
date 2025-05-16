package stringcompressee;

public class App {
	
	public static void main(String[] args) {

		String[] mytestvalues = {"aaaa", "aaaabbb", "aaacjhvjkhvhjvvvvvbbbcccc"};
		
		for(String input : mytestvalues) {
			test(input);
		}
		
		
	}

	public static void test(String test) {

        StringCompressee s = new StringCompressee(test);

        s.printStringCompressee();

        if(test.equals(s.decompresser())) {
            System.out.print("Ok: " + test);
            System.out.println(" (" + s.tailleCompressee() + " vs " + s.tailleOriginale() + " bits)");
        } else {
            System.out.println("Erreur: " + test + s.decompresser());
        }
    }

	
	
}
