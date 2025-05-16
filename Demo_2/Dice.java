import java.util.Random;



/**
 * 
 * @author demoguy
 * @date 2023-05-18
 * 
 * @last-modified 2023-05-18
 * 
 * Nous avons la classe Dice qui modélise un dé a plusieurs faces.
 */
public class Dice {
	
	public int nbdecote;
	
	
	/**
	 * 
	 * @param nbdecote
	 * 
	 * c'est le constructeur
	 */
	public Dice(int nbdecote) {
		this.nbdecote = nbdecote;
	}
	
	/**
	 * C'est la méthode qui roule le de
	 * @return retourne la valeur du roule du dé
	 */
	public int roulerlede() {
		Random rand = new Random();
	    return rand.nextInt(this.nbdecote);

	}

}
