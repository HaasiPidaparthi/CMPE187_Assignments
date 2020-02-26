import java.util.Scanner;

public class scholarship {
	public static void main(final String[] args) {

		Scanner sc = new Scanner(System.in);

		int age;				//variable for A
		boolean lived;			//variable for B
		boolean part_time;		//variable for C
		boolean tax;			//variable for D
		boolean volunteered;	//variable for E
		boolean income;			//variable for E
		int result = 0;			//variable for checking whether eligible or not

		//get information of the age
		System.out.print("Enter Your Age: ");
		age = sc.nextInt();

		//get the information for B
		System.out.println("Have you lived in California for last 2 years?");
		System.out.print("Enter Y/N: ");
		lived = answer(sc.next().charAt(0));

		//get the information of C
		System.out.println("Have you worked part time for at least for 6 months in the relevant field of study?");
		System.out.print("Enter Y/N: ");
		part_time = answer(sc.next().charAt(0));

		//get the information of D
		System.out.println("Have your parents paid California state tax for at least 1 year in lifetime? yes or no: ");
		System.out.print("Enter Y/N: ");
		tax = answer(sc.next().charAt(0));

		//get the information of E
		System.out.println("Have you volunteered for a cause and has a valid proof of it? yes or no: ");
		System.out.print("Enter Y/N: ");
		volunteered = answer(sc.next().charAt(0));

		//get the information of F
		System.out.println("Have your household income less than $5000 per annum? yes or no: ");
		System.out.print("Enter Y/N: ");
		income = answer(sc.next().charAt(0));

		//check the whether the age is valid or not
		boolean pass = validAge(age);

		// check the eligible for scholarship
		if (pass) {
			if (lived) {
				if (part_time) {
					if (tax) {
						if (volunteered) {
							if (income) {
								result = 1;		// all conditions are satisfied
							} else {
								if (part_time) {
									result = 1;		// Only F is not satisfied
								}
							}
						} else {
							if (income) {
								result = 1;
							}
						}
					} else {
						if (volunteered) {
							if (income) {
								result = 1;
							}
						}
					}
				} else {
					if (volunteered) {
						result = 1;		// C is not satisfied, but E is satisfied
					} else {
						result = 0;		// C and E are not satisfied
					}
				}
			} else {
				if (tax) {
					result = 1;  // B is not satisfied, but D is satisfied
				} else {
					result = 0;  // B and C are not satisfied
				}
			}
		}
		
		
		if (!(tax) && !(income)) {
			result = 2; 			// redirected to "Dean for consideration"
		}

		/* Test
		System.out.println(validAge(age));		check the output for A
		System.out.println(lived);				check the output for B
		System.out.println(part_time);			check the output for C
		System.out.println(tax);				check the output for D
		System.out.println(volunteered);		check the output for E
		System.out.println(income);				check the output for F
		System.out.println(result);				check the result whether the eligible or not
		**/

		// 0 for not eligible for scholarship
		if (result == 0) {
			System.out.println("Not eligible for scholarship");
		}
	
		// 1 for not eligible for scholarship
		else if (result == 1) {
			System.out.println("Eligible for scholarship");
		}
	
		// if result is not equal to 0 or 1, the result is Dean for consideration
		else {
			System.out.println("Dean for consideration");
		}
		
	}

	// method to return boolean value from user's age
	public static boolean validAge(int a) {
		if (a < 18 || a > 24) {
			return false;
		} 
		else
			return true;
	}

	// method to return boolean value from user input
	public static boolean answer(final char s) {
		if(s == 'Y' || s == 'y'){
			return true;
		}
		else
			return false;
	}

}
