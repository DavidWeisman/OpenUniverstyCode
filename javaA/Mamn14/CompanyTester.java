public class CompanyTester
{
    public static void main(String[] args)
    {
        Date d1 = new Date(1, 1, 2000);
        
        Date d2 = new Date(6, 1, 2000);
        
        Date d7 = new Date(22, 1, 2000);
        
        Date d9 = new Date(29, 1, 2000);
        
        Car carA = new Car(123456789,'A',"Ford",false);
        Car carB = new Car(123456789,'B',"Ford",false);
        Company c2 = new Company();
        c2.addRent("dudu1", carA, d1, d2);
        c2.addRent("dudu2", carB, d1, d2);
        c2.addRent("dudu1", carA, d2, d7);
        c2.addRent("dudu2", carB, d1, d9);
        c2.removeRent(d7);
        System.out.print(c2.toString());
                
        
    }
}