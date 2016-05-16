import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("MASTERMIND");
		int newgame = 0;
		while (newgame == 0) {
			System.out.println("Print out colors you want to pick from.If you print stop,computer stops recording input: ");
		ArrayList <String> colorSet = new ArrayList<> ();
		String input = scan.next();
		while (input.equals("stop") == false ) { //create a list of user chosen colors
			colorSet.add(input);
			input = scan.next();		  
		}

		System.out.println("Pick a number of slots in which you will place your colored pegs: ");
		int slotNum = scan.nextInt();

		mm test = new mm (colorSet,slotNum); //initialize class mastermind and generate combinations
		System.out.println("Make your guess and keep it in mind: ");
		String response = "";
		String position = ((Integer) slotNum).toString(); //number of black pegs for winning
		while (response.equals("0"+position)==false)  {
			List <String> guess = test.allColors.get(0); //guess is combination from list of unremoved combinations
			System.out.println("Computer's guess is " +guess.toString());//*
			System.out.println("Print out number of correct colors in incorrect positions: ");
			int c = scan.nextInt ();
			System.out.println("Print out number of correct colors in correct positions: ");
			int p = scan.nextInt ();
			response = test.response(c, p); //get response from user
			for (int i = 0; i < test.allColors.size(); i ++) { 
				if (test.guess(guess,test.allColors.get(i)).equals(response) == false) {
					test.allColors.remove(test.allColors.get(i));//remove unsatisfactory combinations
				} 
			}
		}
		System.out.println("Do you want to continue the game? Print Y or N");
      if (scan.next().equals("Y")) { //start new game
    	  newgame = 0;
      } else { //stop game
    	 System.out.println("Thanks for playing");
    	 newgame = 1;
      }
		}
	}

}
