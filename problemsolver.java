import java.util.Scanner;

public class problemsolver {

    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
      
        System.out.println("Enter a number for factorial");
        String limit=inp.nextLine();
         String reverse="";
        for(int i=limit.length()-1;i>=0;i--){
            reverse= reverse+limit.charAt(i);

        }
        
       System.out.println(reverse);
    }
}