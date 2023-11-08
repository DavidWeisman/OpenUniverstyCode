
/**
 * Write a description of class MyTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyTester
{
    public static void main(String[] args) 
    {
        System.out.println("----------------------------------------");
        System.out.println("***       Q1  - shortestRoad         ***");
        System.out.println("----------------------------------------");
        
        System.out.println("Road1:[5,4,5,8,12,9,9,3]");
        System.out.println("Road2:[7,3,3,12,10,2,10,7]");
        int[] road1={5,4,5,8,12,9,9,3};
        int[] road2={7,3,3,12,10,2,10,7};
        int result1=Ex11.shortestRoad(road1, road2);
        if (result1==49)
            System.out.println("Passed, result is 49");
        else
            System.out.println("Failed,  expected: 49   student's result: "+result1);
        
            
        System.out.println("Road3:[4, 5, 2, 8]");
        System.out.println("Road4:[4, 5, 2, 8]");
        int[] road3 = new int[]{4, 5, 2, 8};
        int[] road4 = new int[]{2, 6, 3, 9};
        result1=Ex11.shortestRoad(road3, road4);
        if (result1==17)
            System.out.println("Passed, result is 17");
        else
            System.out.println("Failed,  expected: 17   student's result: "+result1);
        
            
        System.out.println("Road5:[2, 6, 3, 9]");
        System.out.println("Road6:[2, 6, 3, 9]");
        int[] road5 = new int[]{2, 6, 3, 9};
        int[] road6 = new int[]{2, 6, 3, 9};
        result1=Ex11.shortestRoad(road5, road6);
        if (result1==20)
            System.out.println("Passed, result is 20");
        else
            System.out.println("Failed,  expected: 20   student's result: "+result1);
        
    
        System.out.println("Road7:[2, 2, 2, 2]");
        System.out.println("Road8:[3, 3, 3, 3]");
        int[] road7 = new int[]{2, 2, 2, 2};
        int[] road8 = new int[]{3, 3, 3, 3};
        result1=Ex11.shortestRoad(road7, road8);
        if (result1==8)
            System.out.println("Passed, result is 8");
        else
            System.out.println("Failed,  expected: 8   student's result: "+result1);
            
        
        System.out.println("Road9:[4, 0, 2, 8]");
        System.out.println("Road10:[2, 6, 3, 9]");
        int[] road9 = new int[]{4, 0, 2, 8};
        int[] road10 = new int[]{2, 6, 3, 9};
        result1=Ex11.shortestRoad(road9, road10);
        if (result1==12)
            System.out.println("Passed, result is 12");
        else
            System.out.println("Failed,  expected: 12   student's result: "+result1);
        
            
        System.out.println("Road11:[5, 4, 8, 5, 9, 12, 9, 3]");
        System.out.println("Road12:[2, 9, 4, 1, 8, 2, 1, 2]");
        int[] road11 = new int[]{5, 4, 8, 5, 9, 12, 9, 3};
        int[] road12 = new int[]{2, 9, 4, 1, 8, 2, 1, 2};
        result1=Ex11.shortestRoad(road11, road12);
        if (result1==27)
            System.out.println("Passed, result is 27");
        else
            System.out.println("Failed,  expected: 27   student's result: "+result1);
    
    
        System.out.println("----------------------------------------");
        System.out.println("***     Q2  - missingValue           ***");
        System.out.println("----------------------------------------");
        
        int []arr1 = {-2,1,4,7,10,13,16,22,25};
        System.out.println("arr1: [-2,1,4,7,10,13,16,22,25]");
        int result2=Ex11.missingValue(arr1);
        if (result2==19)
            System.out.println("Passed, result is 19");
        else
            System.out.println("Failed,  expected: 19  student's result: "+result2);
        
        int []arr2 = {-2, 4};
        System.out.println("arr2: [-2, 4]");
        result2=Ex11.missingValue(arr2);
        if (result2==1)
            System.out.println("Passed, result is 1");
        else
            System.out.println("Failed,  expected: 1  student's result: "+result2);
    
        int []arr3 = {-8,4,10, 16, 22, 28, 34, 40};
        System.out.println("arr3: [-8,4,10, 16, 22, 28, 34, 40]");
        result2=Ex11.missingValue(arr3);
        if (result2==-2)
            System.out.println("Passed, result is -2");
        else
            System.out.println("Failed,  expected: -2  student's result: "+result2);
    
        int []arr4 = {3, 7, 11, 15, 19, 27};
        System.out.println("arr4: [3, 7, 11, 15, 19, 27]");
        result2=Ex11.missingValue(arr4);
        if (result2==23)
            System.out.println("Passed, result is 23");
        else
            System.out.println("Failed,  expected: 23  student's result: "+result2);
    
    
    }
}
