import java.util.Scanner;
public class Triangle2
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
        
        //Checking if it triangle
        if (b + c <= a || a + c <= b || a + b <= c)
        {
            System.out.println("The numbers: " + a + ", " + b + " and " + c + " cannot represent a triangle");
        }
        else
        {
            //Checking if it represent a right-angle triangle
            if (c == Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) || b == Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)) || a == Math.sqrt(Math.pow(c, 2) + Math.pow(b, 2)))
            {
                System.out.println("The numbers: " + a + ", " + b + " and " + c + " represent a right-angle triangle");
            }
            else
            {
                //Checking if it represent an isosceles triangle
                if (a == c && a == b)
                {
                    System.out.println("The numbers: " + a + ", " + b + " and " + c + " represent an isosceles triangle");
                }
                else
                {
                    //Checking if it represent an equilateral triangle
                    if (b == c || a == c || a == b)
                    {
                        System.out.println("The numbers: " + a + ", " + b + " and " + c + " represent an equilateral triangle");
                    }
                    //Otherwise it is a regular triangle
                    else
                    {
                        System.out.println("The numbers: " + a + ", " + b + " and " + c + " represent a common triangle");
                    }
                }
            }
        }
    }
}
