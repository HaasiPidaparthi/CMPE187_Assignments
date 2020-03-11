import java.util.Scanner;
import java.util.InputMismatchException;

public class GameExpo{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int gender;
        int age;

        System.out.println("Welcome to a Game Expo for Children");

        // get user's gender
        while(true){
            try{
                System.out.print("Please enter your gender (Boy - 0, Girl - 1): ");
                gender = sc.nextInt();
                if (gender == 0 || gender == 1) {
                    break;
                }
                else{
                    System.out.println("You entered invalid input. Please enter valid number (Boy - 0, Girl - 1)");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("You entered invalid input. Please enter valid number (Boy - 0, Girl - 1)");
            }
        }

        // get user's age
        System.out.print("Please enter your age: ");
        age = sc.nextInt();

        if(gender == 0){  
            boy(age);
        }
        else{
            girl(age);
        }
    }

    // scenarios based on age for boy
    public static void boy(int age){
       
        if(age > 7 && age < 10){
            System.out.println("You bought a ticket for participating in Storytelling Competition");
        }
        else if(age > 11 && age < 15){
            System.out.println("You bought a ticket for participating in a Quiz Competition");

        }
        else if(age < 6){
            System.out.println("You bought a ticket for participating in Rhyming Competition");
        }
        else if(age > 20){
            System.out.println("You bought a ticket for participating in Poetry Competition");
        }
        else{
            System.out.println("Sorry. You cannot participate in any competitions");
        }
    }

    // scenarios based on age for girl
    public static void girl(int age){
        
        if(age > 7 && age < 10){
            System.out.println("You bought a ticket for participating in Drawing Competition");
        }
        else if(age > 10 && age < 15){
            System.out.println("You bought a ticket for participating in Essay Writing Competition");
        }
        else if(age < 6){
            System.out.println("You bought a ticket for participating in Rhyming Competition");
        }
        else if(age > 20){
            System.out.println("You bought a ticket for participating in Poetry Competition");
        }
        else{
            System.out.println("Sorry. You cannot participate in any competitions");
        }
    }
}