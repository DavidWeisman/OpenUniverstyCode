import java.util.Scanner;
public class Triangle1
{
    public static void main (String[] args)
    {
        //Preface and receiving the sides of the triangle from the user.
        Scanner scan = new Scanner (System.in);
        System.out.println("This program calculates the area and the perimeter of a given triangle.");
        System.out.println("Please enter the three lengths of the triangle's sides");
        
        //Inputting the sides of the triangle into three variables.
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        
        //Calculate the perimeter of the triangle.
        int p = a + b + c;
        
        //Calculation of half the perimeter of the triangle.
        double s = p / 2.0;
        
        //Calculate the area of ​​a triangle according to Heron's formula.
        double area = Math.sqrt( s * (s - a) * (s - b) * (s - c));
        
        //Output of: the three sides of the triangle, the perimeter of a triangle and the area of ​​a triangle.
        System.out.println("The lengths of the triangle sides are: " + a + "," + b + "," + c + ".");
        System.out.println("The perimeter of the triangle is: " + p);
        System.out.println("The area of the triangle is: " + area);
        
    }
}
