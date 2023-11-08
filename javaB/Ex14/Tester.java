public class Tester
{
    public static void main()
    { 
        /*
        City c1 = new City("Jerusalem", 1, 2, 3, 4, 5, 6, 7, 8, 9);
        City c2 = new City("Tel-Aviv", 11, 12, 13, 14, 15, 16, 17, 18, 19);
        CityNode co1 = new CityNode(c1);
        CityNode co2 = new CityNode(c2);
        co1.setNext(co2);
        System.out.print(co1.getCity());
        System.out.println();
        System.out.print(co1.getNext().getCity());
        */
        
        Country co1 = new Country("israel");
        co1.addCity("ZZZZ", 5, 7, 2020, 5, 10, 7, 8, 12, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        
        co1.addCity("AAAA", 5, 7, 2020, 5, 10, 7, 8, 12, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        
        
        co1.addCity("KKKK", 5, 7, 2020, 5, 10, 7, 8, 12, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        
        co1.addCity("BBBB", 5, 7, 2020, 5, 10, 7, 8, 12, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        // co1.addCity("AAAA", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        
        co1.addCity("CCCC", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        // co1.addCity("ZZZZ", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        co1.addCity("DDDDD", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        co1.addCity("NNNN", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        co1.addCity("KKK", 5, 7, 2021, 5, 10, 7, 8, 12, 19);
        // co1.addCity("Modiin", 1, 7, 2020, 5, 6, 6, 7, 8, 9);
        System.out.println(co1.toString() + "\n==========================\n\n");
        co1.addCity("Tel-Aviv", 2, 7, 2021, 5, 6, 16, 17, 2, 19);
        System.out.println(co1.toString() + "\n==========================\n\n");
        co1.addCity("Bershva", 3, 7, 2020, 5, 5, 30, 10, 4, 19);
        

        co1.unifyCities("Tel-Aviv", "Bershva");
        System.out.println(co1.getNumOfResidents());
        System.out.println(co1.getNumOfCities());
        System.out.println(co1.toString());
        System.out.println(co1.toString() + "\n==========================\n\n");
        
        
    }
}
 