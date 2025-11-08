import java.util.Scanner;

public class a{
    public static void main(String[] args) {
        System.out.println("Enter A number for rows");
        Scanner inp =new Scanner(System.in);
        int a =inp.nextInt();

        for(int i=0 ;i<a;i++){//rows


            for(int j=0;j<i;j++){//cols
                System.out.print("*");
            }
             System.out.println();
            
            }
    }
}