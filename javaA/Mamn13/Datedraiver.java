import java.util.Scanner;
public class Datedraiver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        Date d1 = new Date(day, month, year);
        System.out.println(d1.tomorrow());
       
    
    }
}
