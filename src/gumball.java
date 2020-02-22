import java.util.Scanner;
import java.util.InputMismatchException;

public class gumball{

    public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 

		// Welcome Message!
    	System.out.println("\nWelcome to The Gumball Machine!");
    	System.out.println("Enter one of the following numbers to choose a gumball color:");
    	System.out.println("Red - 0");
    	System.out.println("Yellow - 1\n");

    	// Several variables
    	int color = 2;
    	int coin = 0;
    	int amount = 0;
    	int option = 0;

        // Get the color of the gumball
        while (true) {
            try {
                System.out.print("Enter color choice (Red - 0, Yellow - 1): ");
                color = sc.nextInt();
                if (color == 0 || color == 1) {
                     break;
                } else {
                    System.out.println("Error: Please enter 0 (Red) or 1 (Yellow)\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter 0 (Red) or 1 (Yellow)\n");
                sc.next();
            }
        }
    
    	// Display the value of chosen gumball
        if (color == 0){
        	System.out.println("Red Gumballs are worth a nickel (5 cents)");
        } else {
        	System.out.println("Yellow Gumballs are worth a dime (10 cents)");
        }
        
        // Get gumball money from user
        while (true) {
            try {
                while (option == 0) {
                    System.out.print("\nPlease insert coins (5, 10, or 25 cents only!): ");
                    coin = sc.nextInt();
                    if (coin == 5 || coin == 10 || coin == 25) {
                        amount += coin;
                        while (true) { 
                            try {
                                System.out.print("Add more coins (0) or press Dispenser Lever (1)\nOption: ");
                                option = sc.nextInt(); 

                                // Not enough coins to buy Yellow Gumball
                                if (color == 1 && amount < 10) {
                                    option = 0;
                                    System.out.println("Insufficient coins! Please add more coins for Yellow Gumball!");
                                    break;
                                } else if (option == 0 || option == 1) { break; }   
                                else {
                                    System.out.println("Error: Please enter 0 or 1!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Please enter a valid input!\n");
                                sc.next();
                            }
                        }
                    } else {
                        System.out.println("Error: Machine only accepts 5, 10, or 25 cents!");
                        break;
                    } 
                }
                if (option == 1) break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid input!");
                sc.next();
            }
        }

        // Process and display the total number of gumballs user gets
        System.out.println("\nYou added " + amount + " cents.");
        System.out.println("Processing Gumballs...");
        int gumball_no = totalGumballs(amount, color);

        // Singular / Plural tense for gumball
        if (gumball_no == 1) {
            System.out.println("You bought a total of " + gumball_no + " gumball!");
        } else {
            System.out.println("You bought a total of " + gumball_no + " gumballs!");
        }

        System.out.println("Here is your change: " + change(amount, color) + " cents.");
        System.out.println("\nThank you for using The Gumball Machine! Enjoy!\n");
    }
    
    // Method to calculate the total number of gumablls user gets 
    public static int totalGumballs (int amount, int color) {
    	int gumballs;
    	// Gumball color - Red (5 cents)
    	if (color == 0) {
    		gumballs = amount / 5;
    	} 
    	// Gumball color - Yellow (10 cents)
    	else {
    		gumballs = amount / 10;
    	}
    	return gumballs;
    }  

    // Calculate the remaining change
    public static int change (int amount, int color) {
        int change;
        // Gumball color - Red (5 cents)
        if (color == 0) {
            change = amount % 5;
        } 
        // Gumball color - Yellow (10 cents)
        else {
            change = amount % 10;
        }
        return change;
    }
}