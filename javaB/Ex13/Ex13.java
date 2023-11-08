/**
 * This class represents a Mamn13
 * @author David Weisman
 * @version 27-05-2023
 */
public class Ex13
{
    /**
     * A method accepts a one-dimensional array containing integers.
     * The method returns the length of the longest palindrome in the array.
     * @param one-dimensional array cotaining integers.
     * @return the length of the longest palindrome in the array.
     */
    public static int longestPalindrome (int[] arr)
    {
        return longestPalindrome (arr, 0,1, 0, 1);
    }
    
    // A private method that calculates the length of the longest palindrome.
    // "counter" counts the length of the palindrome every time the method finds a new palindrome.
    // "maxLength" saves the length of the longest palindrome.
    private static int longestPalindrome (int[] arr, int index1, int index2, int counter, int maxLenght)
    {
        // If the array is empty the length of the longest palindrome is 0.
        if(arr.length == 0)
        {
            return 0;
        }
        
        // Check if this is the end of the array.
        if(index1 == arr.length - 1)
            return maxLenght;
        
        // Check if it is a palindrome.
        if(arr[index1] == arr[index2])
        {
            // The number of pairs (of equal digits) in a palindrome can be the length of the palindrome
            // or the length of the palindrome minus one.
            if((index2 - index1 + 1)  == longestPalindrome(arr, index1, index2))
            {
                counter = index2 - index1 + 1;
            }
        }
        
        // Check if there is a longer palindrome.
        if(maxLenght < counter)
            maxLenght = counter;
        
        if(index2 != arr.length - 1)
            return longestPalindrome (arr, index1, index2 + 1, 0, maxLenght);
        return longestPalindrome (arr, index1 + 1, index1 + 2, 0, maxLenght);
    }
    
    // A private methode that calculates the number of equal digits between the indexes "index1", "index2".
    // If there is another number between them the method calculates him also.
    private static int longestPalindrome (int[] arr, int index1, int index2)
    {
        if(index1 == index2)
        {
            return 1;
        }
        if(index1 > index2)
            return 0;
        if(arr[index1] == arr[index2])
        {
            return 2 + longestPalindrome (arr, index1+1, index2-1);
        }
        return 0;
    }
    
    /**
     * A method accepts a one-dimensional array containing integers and one number.
     * The method returns true if there is a subset of the elements of the array, that the sum of the elements equlse to the accept number, otherwise return false.
     * The function fulfills the following conditions:
     * 1. Does not use the values of three adjacent cells
     * 2. Does use the same index value more than once
     * @parem a the array of integers.
     * @param num the one number.
     * @return true if there is a subset of the elements of the array, otherwise return false.
     */
    public static boolean isSum (int[] a, int num)
    {
        return isSum(a,0, 0, num);
    }
    
    // A private method that checking if there if a subset of the elements of the array.
    // "counter" is counting who many are adjacent cells
    private static boolean isSum (int[] a,int counter, int i, int num)
    {
        
        if(num == 0)
        {
            // A subset cannot have three adjacent numbers
            if(counter < 3)
                return true;
        }
        
        if(i == a.length || num < 0)
            return false;
        
        return isSum(a,counter+1 , i+1, num - a[i]) || isSum(a,counter, i+1, num);
    }
}

