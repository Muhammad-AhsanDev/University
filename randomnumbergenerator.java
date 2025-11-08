import java.util.Random;
import java.util.Scanner;

public class randomnumbergenerator{
    public static void main(String[] args) {
        Random rand =new Random();
        int randint =rand.nextInt(101);
    System.out.println(randint);
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess the nuumber");
        int userinp = sc.nextInt();
         if(userinp !=randint){
            System.out.println("Wrong!!!");
         }
        while(userinp != randint){
         System.out.println("Guess the nuumber");
         userinp = sc.nextInt();
         if(userinp !=randint){
            System.out.println("Wrong!!!");
         }
        }
        System.out.println(userinp +"Guesssed the real");
    }
}