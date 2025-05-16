package romain;
public class App {
	
	public static void main(String[] args) {
		
		Romain_solution rom = new Romain_solution(172);

		System.out.println(rom.valeur());

		rom.additioner(2);

		System.out.println(rom.valeur());

		rom.multiplier(2);

		System.out.println(rom.valeur());
	}

}
