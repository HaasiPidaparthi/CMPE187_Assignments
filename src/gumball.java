import java.util.Scanner;

public class gumball{

    int nickel = 0;    // 5
    int dime = 0;    // 10
    int quater = 0; // 25
    int money = 0;
    public static void main(String[] args){

        Scanner gum = new Scanner(System.in);  
        System.out.print("Enter 0 for red gumball or 1 for yellow gumball: ");
        int color = gum.nextInt();


        if(color == 0){
            Scanner sc = new Scanner(System.in); 
            System.out.print("Please insert coins: ");
            String a = sc.nextLine();
            System.out.println(coin(a));



        
// hello


        }

        if (color == 1) {

        }
    }

    public static int coin(String c) {
        if(c.equals("nickel")){
            return 1;
        }

        if(c.equals("dime")){
            return 10;
        }

        if(c.equals("quater")){
            return 25;
        }

        return 0;
    }

}