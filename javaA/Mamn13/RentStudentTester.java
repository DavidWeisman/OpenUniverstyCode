/**
 * Tester for students for class Rent.
 * IMPORTENT: This tester checks only the methods' names and not their correctness. 
 * 
 * @author Course Stass
 */

public class RentStudentTester
{
    public static void main(String[] args) {
        Rent r1=new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));  
        System.out.println("\tr1:"+r1);
        Rent r2=new Rent(r1);
        System.out.println("\tr2:"+r2);
        Car c1 = new Car(7654321, 'D', "Opel", true);
        r1.setCar(c1);
        Date d1 = new Date(8,3,2020);
        r2.setReturnDate(d1);
        System.out.println(r2.toString());
        System.out.println(r1.toString());
    }
}

