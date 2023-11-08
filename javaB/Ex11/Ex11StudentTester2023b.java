public class Ex11StudentTester2023b
{
    public static void main(String[] args) {

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

        System.out.println("----------------------------------------");
        System.out.println("***     Q2  - missingValue           ***");
        System.out.println("----------------------------------------");
    
        int []arr = {-2,1,4,7,10,13,16,22,25};
        System.out.println("arr: [-2,1,4,7,10,13,16,22,25]");
        int result2=Ex11.missingValue(arr);
        if (result2==19)
            System.out.println("Passed, result is 19");
        else
            System.out.println("Failed,  expected: 19  student's result: "+result2);
    }
}