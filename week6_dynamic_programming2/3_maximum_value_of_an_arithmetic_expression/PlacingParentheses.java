import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int nIndex = exp.length();
        int nDigits = (exp.length() + 1) / 2;
        long[][] storeMax = new long[nDigits + 1][nDigits + 1];
        long[][] storeMin = new long[nDigits + 1][nDigits + 1];
        for (int i = 1; i <= nDigits; i++) {
            int index = 2 * (i - 1);
            storeMax[i][i] = Character.getNumericValue(exp.charAt(index));
            storeMin[i][i] = Character.getNumericValue(exp.charAt(index));
        }
//        for (int i = 1; i <= nDigits; i++) {
//            for (int j = 1; j <= nDigits; j++) {
//                System.out.println(storeMax[i][j]);
//                System.out.println(storeMin[i][j]);
//            }
//        }

        for (int d = 1; d <= nDigits - 1; d++) { // difference of i and j
            for (int i = 1; i <= nDigits - d; i++) {
                int j = i + d;
                long[] tmp = minAndMax(i, j, storeMin, storeMax, exp);
                storeMin[i][j] = tmp[0];
                storeMax[i][j] = tmp[1];
            }
        }

        return storeMax[1][nDigits];
    }

    private static long[] minAndMax(int i, int j, long[][] mins, long[][] maxs, String str) {
        long maxVal = -100;
        long minVal = 100;
        for (int k = i; k <= j - 1; k++) {
            char op = str.charAt(2 * (k - 1) + 1);
            long a = eval(mins[i][k], mins[k + 1][j], op);
            long b = eval(mins[i][k], maxs[k + 1][j], op);
            long c = eval(maxs[i][k], mins[k + 1][j], op);
            long d = eval(maxs[i][k], maxs[k + 1][j], op);
            maxVal = Math.max(maxVal, Math.max(d, Math.max(Math.max(a, b), c)));
            minVal = Math.min(minVal, Math.min(d, Math.min(Math.min(a, b), c)));
        }
        long[] minAndMax = {minVal, maxVal};
        return minAndMax;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

