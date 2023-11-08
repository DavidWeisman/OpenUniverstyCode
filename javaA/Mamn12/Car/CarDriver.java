import java.util.Scanner;
public class CarDriver
{
   public static void main(String[] args)
    {      
        //Variables checking a ID of the car.
        final int MAX = 9999999;
        final int MIN = 1000000;
    
        //Overture and input request for ID, type, brand and if is Manual of the first car.
        Scanner scan = new Scanner(System.in);
        System.out.println ("This program demonstrates the usage of Car class."); 
        System.out.println ("Please enter the id, type, brand and if is Manual for the first car:"); 
        
        //Inserting values of the first car into variables.
        int id1 = scan.nextInt();
        char type1 = scan.next().charAt(0);
        String brand1 = scan.next();  
        boolean isManual1 = scan.nextBoolean();  
        Car c1 = new Car(id1, type1, brand1,isManual1);
         
        //Input request for ID, type, brand and if is Manual of the second car.
        System.out.println("Please enter the id, type, brand and if is Manual for the second car:");
        
        //Inserting values of the second car into variables.
        int id2 = scan.nextInt();
        char type2 = scan.next().charAt(0);
        String brand2 = scan.next();
        boolean isManual2 = scan.nextBoolean();
        Car c2 = new Car(id2, type2, brand2,isManual2);
         
        // ID check for both cars. 
        if(c1.getId() < MIN || c1.getId() > MAX)
        {
            c1.setId(MAX);
        }
        if(c2.getId() < MIN || c2.getId() > MAX)
        {
            c2.setId(MAX);
        }
        
        // Type check for both cars.
        switch(c1.getType()) {
            case 'A':
            case 'B':
            case 'C':
            case 'D': 
                break;
            default:
                c1.setType('A');
        } 
        switch(c2.getType()) {
            case 'A':
            case 'B':
            case 'C':
            case 'D': 
                break;
            default:
                c2.setType('A');
        }
        
        // Output of both Car values.
        System.out.println(c1.toString());
        System.out.println(c2.toString());   
        
        //Checking if two cars are identical.
        if (c1.equals(c2))
        {    
            System.out.println("Same car");
        }
        else
        {
            System.out.println("Different cars");
        }
        
        //Update value of the first car gear.  
        c1.setIsManual(!c1.isManual());
        System.out.println(c1.toString());
        
        //Checking which car is better
        if(c1.better(c2))
        {
                    System.out.println(c1.toString());
        }
        else if(c2.better(c1))
        {
            System.out.println(c2.toString());
        }
    }
}
