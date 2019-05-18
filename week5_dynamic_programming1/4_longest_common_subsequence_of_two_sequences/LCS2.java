import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[][] storeCounts = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; i++) {
            storeCounts[i][0] = 0;
        }
        for (int j = 0; j <= bLen; j++) {
            storeCounts[0][j] = 0;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                int lastIncreasedI = -1;
                int lastIncreasedJ = -1;
                int greaterOne = Math.max(storeCounts[i][j-1], storeCounts[i-1][j]);
                // index of i-th element is i-1
                // (i, j+1...) (i+1..., j) is the same
                if (a[i-1] == b[j-1] && lastIncreasedI != i && lastIncreasedJ != j) {
                    lastIncreasedI = i;
                    lastIncreasedJ = j;
                    storeCounts[i][j] = greaterOne + 1;
                } else {
                    storeCounts[i][j] = greaterOne;
                }
            }
        }
        return storeCounts[aLen][bLen];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

