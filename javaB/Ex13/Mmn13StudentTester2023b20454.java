
/**
 * Write a description of class Mmn13StudentTester2023b20454 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mmn13StudentTester2023b20454
{
    public static void main(String[] args) {
        int counterP = 0;
        
        System.out.println("----------------------------------------");
        System.out.println("***     Q1  - longestPalindrome      ***");
        System.out.println("----------------------------------------");
        {
            int[] arr= {1,3,2,3,10,10,3,2,4};
            System.out.println("arr: [1,3,2,3,10,10,3,2,4]");
            int result3=Ex13.longestPalindrome(arr);
            if(result3==6)
            {
                System.out.println("Passed, result is 6");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: 6  student's result: "+result3);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("***     Q2  - longestPalindrome      ***");
        System.out.println("----------------------------------------");
        {
            int[] arr= {3,3,2,3,10,10,3,2,4,7,5,6,5,7,4,2};
            System.out.println("arr: [3,3,2,3,10,10,3,2,4,7,5,6,5,7,4,2]");
            int result3=Ex13.longestPalindrome(arr);
            if(result3==9)
            {
                System.out.println("Passed, result is 9");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: 9  student's result: "+result3);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("***     Q3  - longestPalindrome      ***");
        System.out.println("----------------------------------------");
        {
            int[] arr= {};
            System.out.println("arr: []");
            int result3=Ex13.longestPalindrome(arr);
            if(result3==0)
            {
                System.out.println("Passed, result is 0");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: 0  student's result: "+result3);
        }
        
        
        System.out.println("----------------------------------------");
        System.out.println("***     Q4  - longestPalindrome      ***");
        System.out.println("----------------------------------------");
        {
            int[] arr= {5,3,2,7,8,3};
            System.out.println("arr: [5,3,2,7,8,3]");
            int result3=Ex13.longestPalindrome(arr);
            if(result3==1)
            {
                System.out.println("Passed, result is 1");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: 1  student's result: "+result3);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("***       Q1  - isSum                ***");
        System.out.println("----------------------------------------");
        {
            int[] arr={5,4,2,1,3};
            int num=8;
            System.out.println("arr: [5,4,2,1,3]  num: 8");
            boolean result4=Ex13.isSum(arr, num);
            if (result4==true)
            {
                System.out.println("Passed, result is true");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: true   student's result: "+result4);
            System.out.println("----------------------------------------");

        }
        
        System.out.println("----------------------------------------");
        System.out.println("***       Q2  - isSum                ***");
        System.out.println("----------------------------------------");
        {
            int[] arr={5,4,2,1,3};
            int num=0;
            System.out.println("arr: [5,4,2,1,3]  num: 0");
            boolean result4=Ex13.isSum(arr, num);
            if (result4==true)
            {
                System.out.println("Passed, result is true");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: true   student's result: "+result4);
            System.out.println("----------------------------------------");

        }
        
        System.out.println("----------------------------------------");
        System.out.println("***       Q3  - isSum                ***");
        System.out.println("----------------------------------------");
        {
            int[] arr={5,4,2,1,3};
            int num=11;
            System.out.println("arr: [5,4,2,1,3]  num: 11");
            boolean result4=Ex13.isSum(arr, num);
            if (result4==false)
            {
                System.out.println("Passed, result is false");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: false   student's result: "+result4);
            System.out.println("----------------------------------------");

        }
        
        System.out.println("----------------------------------------");
        System.out.println("***       Q4  - isSum                ***");
        System.out.println("----------------------------------------");
        {
            int[] arr={5,4,2,1,3};
            int num=17;
            System.out.println("arr: [5,4,2,1,3]  num: 17");
            boolean result4=Ex13.isSum(arr, num);
            if (result4==false)
            {
                System.out.println("Passed, result is false");
                counterP++;
            }
            else
                System.out.println("Failed,  expected: false   student's result: "+result4);
            System.out.println("----------------------------------------");

        }
        
        System.out.println("----------------------------------------");
        System.out.println("***           RESULTS                ***");
        System.out.println("----------------------------------------");
        if(counterP == 8)
            System.out.println("ALL THE TESTERS PASSEDS");
        else
            System.out.println("FAILED");
        System.out.println("----------------------------------------");
    }
}
