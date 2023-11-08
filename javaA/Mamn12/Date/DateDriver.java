import java.util.Scanner;
public class DateDriver
{ 
   public static void main(String[] args)
   {
       //Overture and input request for the date.
       Scanner scan = new Scanner(System.in);
       System.out.println ("This program demonstrates the usage of Date class."); 
       System.out.println("Please enter the day, month, year of the first date: ");
       
       //Inserting values of the first date into variables.
       int day = scan.nextInt();
       int moth = scan.nextInt();
       int year = scan.nextInt();
       Date d1 = new Date(day, moth, year);
       Date d2 = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
       
       // Output of both dates values.
       System.out.println(d1.toString());
       System.out.println(d2.toString());
       
       //Checking whether two dates are the same
       if(d2.equals(d1) == true)
       {
           System.out.println("Same date"); 
       }
       else
           System.out.print("Different dates");
       
       //Update of the month of the first date
       d1.setMonth(1);
       System.out.println(d1.toString());
       
       //Update of the year of the second date
       d2.setYear(year + 1);
       System.out.println(d2.toString());
       
       // Output of the second date values.
       String s = "";
       if(d2.getDay() < 10)
            s = s + "0" + d2.getDay() + "/";
       else 
            s = s + d2.getDay() + "/";
       if(d2.getMonth() < 10)
            s = s + "0" + d2.getMonth() + "/";
       else 
            s = s + d2.getMonth() + "/";
       s = s + d2.getYear();
       System.out.println(s);
       
       //Checking whether two dates are the same otherwise, Output of the both dates values.
       if(d2.equals(d1) == true)
           System.out.println("Same dates"); 
       else
       {
           if (d2.before(d1) == true)
           {
               System.out.println(d2.toString());
               System.out.println(d1.toString());
           }
           else
           {
               System.out.println(d1.toString());
               System.out.println(d2.toString());           
           }
       }
   }
}
