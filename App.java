import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        double a  = inp.nextDouble();
        double b=inp.nextDouble();
int Fc;
//  y = x^3 - X^2 - 3*x + 3


double fa = (Math.pow(a,3.0)) -(Math.pow(a,2))-(3*a)+3;



double fb = (Math.pow(b,3.0)) -(Math.pow(b,2))-(3*b)+3;


if (fa == 0)
    System.out.println("Solution of the given equation is "+a);
    System.exit(0);
if (fb == 0 )
   System.out.println("Solution of the given equation is "+b);
    System.exit(0);

double fx =fa*fb;

if(fx>0) //if on the solution of the multiplication is graterthan zero this is not the point where the equation lies as itwill be not be  LHS=RHS
{
System.out.print("Solution does not lies between the given values");
System.exit(0);
}

double c = (a+b)/2;
double fc = (Math.pow(c,3.0)) -(Math.pow(c,2))-(3*c)+3;
if (fc ==0) //if the f(c)==0 then the solution will be c   
{
    System.out.println("Solution is "+c);
        System.exit(0);
}

Fc=(int)fc;

while( Fc>0);
{
    if((fa*fc)<0){
        b=c;
    }
    if((fb*fc)<0)
        a = c;
    c = (a+b);
    fc=(Math.pow(c,3.0)) -(Math.pow(c,2))-(3*c)+3;;
    Fc= (int)fc; 

}
System.out.println(fc);
    }
}

