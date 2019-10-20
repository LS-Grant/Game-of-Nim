/*
* Student Number 914103
* Attempted level 3
*/
import java.util.Scanner;

public class Nim 
{
	
	//Declaration of constants
	public static final int TOKEN_IN_BAG = 10;
	public static final String CHOSE_NO_TOKENS = "Now choose no. of tokens: ";
	public static final String GAME_OVER = "Game Over - Player # wins ";
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		int[] tokenCount = { TOKEN_IN_BAG, TOKEN_IN_BAG, TOKEN_IN_BAG };
		// This Variable declares which user is currently playing
		int playerCounter = 1;
		int bagChosen;
		
		//This loop will continue until all arrays are empty (until game is over)
		while(tokenCount[0] + tokenCount[1] + tokenCount[2] !=0)
			
		{
			//player chooses bag
			System.out.print("Player " + playerCounter + " - choose bag: ");
			while (!input.hasNextInt())
				//This loop is put in place to catch any Invalid data types e.g. String
			{
				System.out.print("your input is not  valid, please input a number ");
				input.next();
			}
			
			bagChosen = input.nextInt();
			
			while (bagChosen < 1 || bagChosen > 3)
				// This loop makes sure that a valid number/data type has been input
			{
						System.out.print("Please pick a bag between 1 and 3 ");
						bagChosen = inputValidInt();
			}
			
			//Sets the bag the user has chosen (-1 because arrays start at 0)
			bagChosen -=1;
			
			
			System.out.print(CHOSE_NO_TOKENS);
			
			// This variable is when checking if the user has taken an invalid amount of tokens
			int overflowCheck;
			
			while (!input.hasNextInt())
				//This loop is put in place to catch any Invalid data types e.g. String
			{
				System.out.print("your input is not valid, please input a number ");
				input.next();
			}
				overflowCheck = input.nextInt();
			
			while (overflowCheck < 0 || overflowCheck > tokenCount[bagChosen])
				// This loop makes sure that a valid number/data type has been input
			{
						System.out.print("Invalid number of tokens, please enter a new value ");
						overflowCheck = inputValidInt();
			}
			// Sets the new value for the tokens in the assigned bag and prints out the value of all bags
			tokenCount[bagChosen] -= overflowCheck;
			System.out.println("Bag Status: " + tokenCount[0] + ", " + tokenCount[1] + ", " + tokenCount[2]);
			
			// IF statement used to initate the next players turn
			if(playerCounter == 1)	
				
			{
				playerCounter = 2;
			}
			
			else
				playerCounter = 1;
			
		}
		
		//Victory/Gameover message
		System.out.println("Game Over - Player " + playerCounter +  " wins"); 
	}
	//Private method used to deal with inputing and validating ints
	private static int inputValidInt()
	{
		int validNum;
		/* This loop is set up to ensure that any inputs from requests
		are actually valid intgers and not strings or invalid integers
		e.g. "please inpout a valid number" error messages (not just
		general invalid inputs)
		*/
		
		while(!input.hasNextInt())
		{
			System.out.print("Your input is not valid, please input a number ");
			input.next();
		}
		// Sets the new valid input integer and returns the value to the designated loop
		validNum = input.nextInt();
		return validNum;
	}
}
