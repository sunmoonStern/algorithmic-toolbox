import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] minNumCoins = new int[m]; // i = 0 represents money = 1, i = n - 1 represents money n
        minNumCoins[0] = 1;
        if (m > 1) {
            minNumCoins[1] = 2;
        }
        if (m > 2) {
            minNumCoins[2] = 1;
        }
        if (m > 3) {
            minNumCoins[3] = 1;
        }
        for (int i = 4; i < m; i++) {
            int numCoins = m;
            int[] coins = {1, 3, 4};
            for (int c : coins) {
                int tempNumCoins = minNumCoins[i - c] + 1;
                if (tempNumCoins < numCoins) {
                    numCoins = tempNumCoins;
                }
            }
            minNumCoins[i] = numCoins;
        }
        return minNumCoins[m - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

