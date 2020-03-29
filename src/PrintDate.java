
import java.util.*; 
import java.text.*; 

public class PrintDate{

	final static Calendar cal = Calendar.getInstance();
	final static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
 
    public static void main(String args[]){
    	boolean validDate = false;
    	String input = "";

        // get the current dates from user
        Scanner sc = new Scanner(System.in);
        dateFormat.setLenient(false);

        while(!validDate) {
	        try {
	        	System.out.print("Enter a date (MM/DD/YYYY): ");
	        	input = sc.nextLine();
	        	Date date = dateFormat.parse(input);

	        	// check year
				cal.setTime(date); 
	        	boolean year = validYear(input);
	        	if (year) { 
	        		validDate = true; 
	        	} 
	        	else { 
	        		System.out.println("Error: Not a valid year. Enter between 1900-2099!\n");
	        		validDate = false; 
	        	}
	        
	        } catch (ParseException e) {
	        	System.out.println("Error: Invalid input\n"); 
	        }
	    }
	    //System.out.println(date);
        String next = nextDate(input);
        System.out.println("You entered: " + input);
        System.out.println("Next Day: " + next + "\n");
    }
    
    public static String nextDate(String input) { 
        String tomorrow = "";
        try {	
        	Date date = dateFormat.parse(input);
        	cal.setTime(date);    
            
            cal.add(Calendar.DAY_OF_YEAR, 1); 
            tomorrow = dateFormat.format(cal.getTime());
        } catch (ParseException e) {
        	System.out.println("Error: Invalid input\n");
        }
        return tomorrow;
    }

    // check the dates are between the year 1900 and 2099 inclusive
    public static boolean validYear(String date){
        int year = cal.get(Calendar.YEAR);
        if (year < 1900 || year > 2099) {
            return false;
        }
        else{
            return true;
        } 
    }
}
