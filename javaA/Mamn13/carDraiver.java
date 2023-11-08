import java.util.Scanner;
public class carDraiver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int id1 = scan.nextInt();
        char type1 = scan.next().charAt(0);
        String brand1 = scan.next();  
        boolean isManual1 = scan.nextBoolean();  
        Car c1 = new Car(id1, type1, brand1,isManual1);
        Car c2 = new Car(c1);
        System.out.println(c1.better(c2));
        System.out.println(c1.worse(c2));

    }
}
