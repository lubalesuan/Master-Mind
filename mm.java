
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class mm {   /**alleviate your main method too much in it*/ //correct color, correct position
int slotNum;
String result;
ArrayList <ArrayList<String>> allColors = new ArrayList <> ();

	/**takes list of colors form user and generates combinations*/
	public mm ( ArrayList<String> colorList, int slotNum) { //avoid repetition make more elegant
		/**constructor*/
		this.slotNum = slotNum;
		allColors = combinations (colorList,slotNum);
	}

	/**generates combinations of all colors input by the user*/
	public  ArrayList<ArrayList<String>> combinations (ArrayList<String> colorList, int slotNum) { //would it work if take list as parameter isntead of array
		if (slotNum == 1) { //base case
			ArrayList <ArrayList<String>> allCombs = new ArrayList <> ();
			for (int i = 0; i < colorList.size(); i++) {
				allCombs.add(new ArrayList<String>()); //add user's list of colors 
				allCombs.get(i).add(colorList.get(i));
			}
					
			return allCombs;
		}
		else {
			ArrayList <ArrayList<String>> allCombs = new ArrayList <> ();
	for (String i : colorList) {
		ArrayList <ArrayList<String>> subColors = combinations (colorList, slotNum-1); //recursion
		for (ArrayList k : subColors) {
			k.add(i) ; //add the String to ArrayList in subColors
			allCombs.add(k); //add ArrayList to the list of allCombinations
		}
	}
			return allCombs;
		}
		}
	

/** returns number of pegs of correct colors and pegs of correct colors in correct poisitons
 * by taking two Lists and analyzing them*/
	public String guess (List<String> guess, List <String>trial) {
		List<String> copyList = new ArrayList<>();
		int c= 0;
		int p = 0;
		for (String el: trial) { // create copy of trial array 
			copyList.add(el);
		}
		for (int i = 0; i < guess.size(); i++) {//why - 1?
			if (trial.get(i).equals(guess.get(i))) {
				p++;
				copyList.remove(guess.get(i)); //remove elements from copy to avoid counting elements more than once
			} else if (copyList.contains(guess.get(i))) { //check if copy contains the element
				c++;
				copyList.remove(guess.get(i));
			}
		}
				String result = ((Integer)c).toString()+((Integer)p).toString();
		return result;
	}

	/**processing user's response (takes number of pegs of correct colors and pegs of correct colors
	 * in correct positions)*/
	  public String response (int rightColor, int rightColorPos) {
       result = ((Integer)rightColor).toString()+((Integer)rightColorPos).toString();
       return result;
	}
	  
	
	public List<String> nextMove () { //returns computer's next guess
		return allColors.get(0);
	}
 public ArrayList<ArrayList<String>> getCombs () {
	 return allColors;
 }

}


