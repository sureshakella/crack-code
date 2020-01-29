package fornow.arrays;

import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
public class MatrixDiagonalPrint {
    public static void main(String[] args) {
//        Diagonal printing of matrix is
//        1
//        5     2
//        9     6     3
//        13    10     7     4
//        17    14    11     8
//        18    15    12
//        19    16
//        20
        int matrix[][] = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16},
                            {17, 18, 19, 20}};
//        int matrix[][] = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}};
//        int matrix[][] = {
//                {1, 2, 3},
//                {5, 6, 7},
//                {9, 10, 11},
//                {13, 14, 15}};
        int rows = matrix.length, cols = matrix[0].length;
        int srIdx=0, scIdx=0, erIdx=0, ecIdx=0;
        while(erIdx<=rows-1 && ecIdx<=cols-1) {
            for(int i=srIdx, j=scIdx; i>=erIdx && j<=ecIdx;i--,j++){
                System.out.print(" " + matrix[i][j]);

            }
            if (srIdx+1 != matrix.length) srIdx++;
            else scIdx++;
            if (ecIdx+1 != matrix[0].length) ecIdx++;
            else erIdx++;
            System.out.println();
        }
    }
}
