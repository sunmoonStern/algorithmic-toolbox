import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int n = A.length;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot += A[i];
        }
        if (tot % 3 != 0) return 0;
        int split = tot / 3;
        for (int i = 0; i < n; i++) {
            if (A[i] > split) return 0;
        }
        if (optimalWeight(split, A) != split) return 0;
        // reconstruct
        return 1;
    }

    static int optimalWeight(int W, int[] w) {
        int result = 0;
        int[][] valueStocker = new int[w.length+1][W+1];

        for (int i = 0; i <= w.length; i++) {
            valueStocker[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            valueStocker[0][j] = 0;
        }
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                int v = 0;
                valueStocker[i][j] = valueStocker[i-1][j];
                // i-th element of w is w[i-1]
                if (w[i-1] <= j) {
                    v = valueStocker[i-1][j-w[i-1]] + w[i-1]; // value is proportinal to weight
                }
                if (v > valueStocker[i][j]) valueStocker[i][j] = v;
            }
        }
        return valueStocker[w.length][W];
    }

//    static int[] reconstruct(int[] w, int[][] v) {
//        if (w.length !=  v.length - 1) System.exit();
//        int nWeight = w.length;
//        int W = v[0].length - 1;
//        int iRow = w.length;
//        int iCol = W;
//        int[] flagUsed = new int[w.length];
//        for (int i = 0; i < iRow; i++) {
//            flagUsed[i] = 0;
//        }
//        if (v[iRow][iCol] == v[iRow-1][iCol]) {
//            // an optimal solution without using this weight(iRow-th element) exists
//            flagUsed[iRow-1] = 1;
//            iRow--;
//        }
//        if (v[iRow][iCol] == v[iRow-1][iCol-w[iRow-1]] + w[iRow-1]) {
//            // an optimal solution using this weight(iRow-th element) exists
//            flagUsed[iRow-1] = 0;
//            iCol -= w[iRow-1];
//            iRow--;
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

