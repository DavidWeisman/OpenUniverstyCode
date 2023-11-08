/**
 * This class represents a Company object
 * @author David Weisman
 * @version 19-01-2023
 */
public class MagicSquare
{
    /**
     * Calculates the sum of all terms in a row
     * @param mat the square matrix
     * @param row the number of the row
     * @return sum of the terms in a row
     */
    public static int sumRow(int [][]mat, int row) 
    {
        int sum = 0;
        for(int i = 0; i < mat.length; i++)
        {
            sum += mat[row][i];
        }
        return sum; 
    }
    
    /**
     * Calculates the sum of all terms in a column
     * @param mat the square matrix
     * @param col the number of the column
     * @return sum of the terms in a column
     */
    public static int sumCol(int [][]mat, int col)
    {
        int sum = 0;
        for (int i = 0; i < mat.length; i++)
        {
            sum += mat[i][col];
        }
        return sum;
    }
    
    /**
     * Calculates the sum of all terms in the first diagonal
     * @param mat the square matrix
     * @return sum of the terms in the first diagonal
     */
    public static int sumPrimaryDiag(int [][]mat)
    {
        int sum = 0;
        for (int i = 0; i < mat.length; i++)
        {
            sum += mat[i][i];
        }
        return sum;
    }
    
    /**
     * Calculates the sum of all terms in the second diagonal
     * @param mat the square matrix
     * @return sum of the terms in the second  diagonal
     */
    public static int sumSecondaryDiag(int [][]mat)
    {
        int sum = 0;
        int num = mat.length - 1;
        for (int i = 0; i < mat.length; i++)
        {
            sum += mat[i][num - i];
        }
        return sum;
    }
    
    /**
     * Checks if the matrix is ​​a magic square
     * @param mat matrix
     * @return true if the matrix is a magic square, otherwise false
     */
    public static boolean isMagicSquare(int [][]mat)
    {
        // Checking whether the terms of rows is equal to the terms of columns in each row
        for (int i = 0 ; i < mat.length; i++)
        {
            if(mat.length != mat[i].length) 
            {
                return false;
            }
        }
        
        // Variables for the sum of the elements in the column, row, first diagonal and second diagonal
        int num1 = sumSecondaryDiag(mat);
        int num2 = sumPrimaryDiag(mat);
        int num3 = sumRow(mat, 0);
        int num4 = sumCol(mat, 0);
        
        //Checking if the sum of the terms in each row is equal among all the other rows
        for (int i = 1 ; i < mat.length; i++)
        {
            if(num3 != sumRow(mat, i))
            {
                return false;
            }
        }
        
        //Checking if the sum of the terms in each column is equal among all the other columns
        for (int i = 1 ; i < mat.length; i++)
        {
            if(num4 != sumCol(mat, i))
            {
                return false;
            }
        }
        
        // Checking that the sum of all terms in each row, column and diagonal are equal
        if (num1 != num2 || num2 != num3 || num3 != num4) 
        {
            return false;
        }
        return true;
    }
}
