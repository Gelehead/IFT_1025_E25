package demo;
public class App {
	public static void main(String[] args) {

		Dice_demo dice = new Dice_demo(9);
		for(int i =0 ; i<20 ; i++)
		{

			System.out.println( dice.roll_dice() ); // rouler le de
		}
	}

}
