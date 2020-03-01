import java.util.Scanner;
import java.util.*;

public class Scholarship {
	public static void main(final String[] args) {

		Scanner sc = new Scanner(System.in);

		int age = 0;						//variable for A
		String residency = null;			//variable for B
		String part_time = null;			//variable for C
		String state_tax = null;			//variable for D
		String volunteered = null;			//variable for E
		String income = null;				//variable for F
		boolean success;					// checks for valid user input
		
		// Get student age
		success = false;
		while (!success) {
			try {
				System.out.print("Enter Your Age: ");
				age = sc.nextInt();
				success = true;
			} catch (InputMismatchException e){
				sc.next();
                System.out.println("Error: You have entered invalid data!\n");
			}
		}
		// check eligible for scholarship
		if (!validAge(age)) {
			exit_message(0);
			System.exit(0);
		}

		// Has the student lived in California for last 2 years
		success = false;
		System.out.println("\nHave you lived in California for the last 2 years?");
		System.out.print("Enter Y/N: ");
		while (!success) {
			residency = sc.next().trim().toUpperCase();
			if (residency.equals("Y") || residency.equals("N")) {
				success = true;
				break;
			} else {
				System.out.println("Error: Please enter Y or N!\n");
			}
		}
		if (residency.equals("N")) {
			// Parents of the student paid California state tax for at least 1 year
			success = false;
			System.out.println("\nDid your parents pay California state tax for at least 1 year in their lifetime?");
			System.out.print("Enter Y/N: ");
			while (!success) {
				state_tax = sc.next().trim().toUpperCase();
				if (state_tax.equals("Y") || state_tax.equals("N")) {
					success = true;
					break;
				} else {
					System.out.println("Error: Please enter Y or N!\n");
				}
			}
			// check eligible for scholarship
			if (state_tax.equals("N")) {
				exit_message(0);
				System.exit(1);
			}
		}

		// Has household income less than $5000 per annum
		success = false;
		System.out.println("\nIs your household income less than $5000 per annum?");
		System.out.print("Enter Y/N: ");
		while (!success) {
			income = sc.next().trim().toUpperCase();
			if (income.equals("Y") || income.equals("N")) {
				success = true;
				break;
			} else {
				System.out.println("Error: Please enter Y or N!\n");
			}
		}
		if (income.equals("Y")) {
			// dean for consideration
			exit_message(2);
			System.exit(2);
		}

		// Did student work part-time for at least 6 months
		success = false;
		System.out.println("\nHave you worked part time for at least for at least 6 months in the relevant field of study?");
		System.out.print("Enter Y/N: ");
		while (!success) {
			part_time = sc.next().trim().toUpperCase();
			if (part_time.equals("Y") || part_time.equals("N")) {
				success = true;
				break;
			} else {
				System.out.println("Error: Please enter Y or N!\n");
			}
		}
		if (part_time.equals("N")) {
			// Student volunteered for a cause
			success = false;
			System.out.println("\nHave you volunteered for a cause and have a valid proof of it?");
			System.out.print("Enter Y/N: ");
			while (!success) {
				volunteered = sc.next().trim().toUpperCase();
				if (volunteered.equals("Y") || volunteered.equals("N")) {
					success = true;
					break;
				} else {
					System.out.println("Error: Please enter Y or N!\n");
				}
			}
			// check eligible for scholarship
			if (volunteered.equals("N")) {
				exit_message(0);
				System.exit(3);
			}
		}

		exit_message(1);
	}

	// print exit message
	public static void exit_message(int result) {
		// 0 - not eligible for scholarship
		if (result == 0) {
			System.out.println("\nScholarship Result: Not eligible for scholarship");
		}
		// 1 - eligible for scholarship
		else if (result == 1) {
			System.out.println("\nScholarship Result: Eligible for scholarship");
		}
		else {
			System.out.println("\nScholarship Result: Dean for consideration");
		}
	}

	// method to return boolean value from user's age
	public static boolean validAge(int a) {
		if (a < 18 || a > 24) return false; 
		else return true;
	}
}