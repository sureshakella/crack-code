package fornow.arrays;

//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
public class MatrixSpiralPrint {
    public static void main(String[] args) {
        //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
//        int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9},{10,11,12}};
//        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
//        int matrix[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },{ 13, 14, 15, 16, 17, 18 } };
        int[][] matrix = { { 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 } };
        int srIdx = 0, erIdx = matrix.length-1;
        int scIdx = 0, ecIdx = matrix[0].length-1;
        while(srIdx <= erIdx && scIdx <= ecIdx) {
            printOuterMatrix(srIdx,erIdx, matrix, scIdx, ecIdx);
            srIdx++;
            erIdx--;
            scIdx++;
            ecIdx--;
        }
    }

    private static void printOuterMatrix(int srIdx, int erIdx, int[][] matrix, int scIdx, int ecIdx) {
        for(int i=srIdx,j=scIdx; j<=ecIdx; j++) {
            System.out.print(" " + matrix[i][j]);
        }
        for(int i=srIdx+1,j=ecIdx; i<=erIdx; i++) {
            System.out.print(" " + matrix[i][j]);
        }
        for(int i=erIdx,j=ecIdx-1; srIdx!= erIdx && j>=scIdx; j--) {
            System.out.print(" " + matrix[i][j]);
        }
        for(int i=erIdx-1,j=srIdx; i>=srIdx+1; i--) {
            System.out.print(" " + matrix[i][j]);
        }
    }
}
