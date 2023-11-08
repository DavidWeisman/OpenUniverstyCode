/**
 * This class represents a Mamn12
 * @author David Weisman
 * @version 13-05-2023
 */
public class Ex12
{
    /**
     * A method that accepts a positive integer number and returns 
     * the length of the longest sequence of digits found in a number.
     * @param one positive integer number
     * @return the longest sequence of digits found in a number.
     */
    public static int equalDigits (int num) 
    {
        return equalDigits(num, 0, 0);
    }
    
    // A private method that accepts positive integer number and two counters.
    // In the second counter (max2) is the longest sequemce of digits and the first counetr (max1) is counting every time sequence of digits and comparing to (max2).
    // if (max2) if smaller so ther is new longest sequence of digits and then (max2) turned in to (max1), until the num end.
    // The method return the longst sequence of digits in the number (num).
    private static int equalDigits(int num, int max1, int max2)
    {
        if(num == 0)
            return max2 + 1;
        
        // Check if the next digit if the same digit,
        if(num % 10 == (num / 10) % 10)
            max1 += 1;
        else
            if(max2 < max1)
            {
                return equalDigits(num /((int)Math.pow(10, max2)), 0, max1); // The new num is the same like as it was but without the sequence of digits.
            }
        return equalDigits(num /10, max1, max2);
    }
    
    /**
     * A method that accepts a positive integer number and a digit,
     * The method returns the a subnumber in which all the digits are divisible by the digit.
     * @param positive interger number.
     * @param digit between zero and nine.
     * @return subnumber in which all the digits are divisible by the digit.
     */
    public static int subNumber (int num, int digit) 
    {
        if(num == 0)
            return 0;
        
        //Check if the first digit of the number (n) is divisible by the digit
        if(num % 10 % digit == 0)                         
            return (num % 10) + subNumber(num / 10, digit) * 10;
            
        return subNumber(num / 10, digit);
    }
    
    /**
     * A method that accepts a positive integer number and
     * return true if the number is special number, false if the number isn't special number.
     * @param positive integer number.
     * @return true if the number is special number, false if the number isn't special number 
     */
    public static boolean isSpecial (int n) 
    {
        return isSpecial(n, 2);
    }
    
    // A private method that accepts the number that maybe special (n), and 'index' position of the non-special numbers.
    // The method return true if the number special and false othewise.
    private static boolean isSpecial(int n, int index)
    {
        if(n < index)
            return true;
        
        //Check if the number isn't special.
        if(n % index == 0) 
            return false;
        
        return isSpecial(n - (n/ index) , index + 1);
    }
}
