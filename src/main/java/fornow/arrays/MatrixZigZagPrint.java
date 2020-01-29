package fornow.arrays;

//https://www.geeksforgeeks.org/print-given-matrix-zigzag-form/
public class MatrixZigZagPrint {
    public static void main(String[] args) {
//        Input :
//        1    2   3   4   5
//        6    7   8   9   10
//        11   12  13  14  15
//        16  17  18  19   20
//        Output :
//        1 2 3 4 5 10 9 8 7 6 11 12 13 14 15 20 19 18 17 16
//
//        Input :
//        10    24   32
//        50    6    17
//        99    10   11
//
//        Output :
//        10 24 32 17 6 50 99 10 11
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        int rows = matrix.length, cols = matrix[0].length;
        boolean l2r = true;
        for(int i=0; i<rows; i++) {
            if (l2r) {
                for (int j = 0; j < cols; j++ ) {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            else {
                for (int j = cols -1; j >=0; j-- ) {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            l2r = !l2r;
        }
    }
}
