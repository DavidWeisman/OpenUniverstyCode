public class MagicSquareTester
{
    public static void main(String[] args)
    {
        int[][] mat1 =
        {
            {17,24,1,8,15},
            {23,5,7,14,16},
            {4,6,12,20,22},
            {10,12,19,21,3},
            {11,18,25,2,9}
        };
        
        int[][] mat2 =
        {
            {2,9,3},
            {7,5,3},
            {6,1,8}
        };
        
        System.out.print(MagicSquare.isMagicSquare(mat2));
    }
}
