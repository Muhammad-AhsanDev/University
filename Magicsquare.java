import java.util.Scanner;

public class Magicsquare{
    public static void main(String[] args) {
    int[][] arry ={{0,0,0,0,0},
                   {0,0,0,0,0},
                   {0,0,0,0,0},
                   {0,0,0,0,0},
                   {0,0,0,0,0}};

                arry[0][2]= 1;
                int row =0;
                int colmb=2;
            for(int i=2;i<=25;i++){
               int prevrow=row;
               int prevcolmb=colmb;
             colmb++;
             row--;
             if(row<0){
                row=4;
             } 
             if(colmb>4){
                colmb=0;
             }
             if(arry[row][colmb]!=0){
                row = prevrow + 1;
                colmb = prevcolmb;
             }
          
             arry[row][colmb]=i;
                   
                    

                   }
   for(int g=0;g<5;g++){
    for(int j=0;j<5;j++){
        System.out.print(arry[g][j]+" ");
    }
    System.out.println();
   }
                }


}