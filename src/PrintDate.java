import java.util.*; 
import java.text.*; 
public class PrintDate{

    public static void main(String args[]){
        // get the current dates from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the current date");
        System.out.print("Format is (MM/DD/YYYY): ");
        String current = sc.nextLine();
        nextDate(current);
    } 

    public static void nextDate(String date){ 
        SimpleDateFormat dayFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance(); 
        
        try {
            Date current = dayFormat.parse(date);     
            cal.setTime(current); 
            cal.add(Calendar.DAY_OF_YEAR, 1); 
            String tomorrow  = dayFormat.format(cal.getTime());

            boolean year = validYear(cal.get(Calendar.YEAR));

            if(!year){
                System.out.println("Next date is " + tomorrow ); 
            }
            else{
                System.out.println("Invalid year"); 
            }
        } 
        catch (ParseException e) {
            System.out.println("Invalid input"); 
        }
    }
    // check the dates are between the year 1900 and 2099 inclusive
    public static boolean validYear(int year){
        boolean check = false;
        if(year <= 1900 || year >= 2099){
            return check = true;
        }
        else{
            return check;
        } 
    }
}