import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

