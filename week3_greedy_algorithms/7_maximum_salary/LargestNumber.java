import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        List<Integer> remainingInts = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            remainingInts.add(Integer.parseInt(a[i]));
        }
        while (remainingInts.size() > 0) {
            int maxDigit = -1;
            for (int k : remainingInts) {
                if (IsGreaterOrEqual(k, maxDigit)) {
                    maxDigit = k;
                }
            }
            remainingInts.remove(Integer.valueOf(maxDigit)); // removeAll does not work
            result += String.valueOf(maxDigit);
        }
        return result;
    }

    private static boolean IsGreaterOrEqual(int l, int maxDigit) {
        // need to update this logic properly
        if (maxDigit < 0) return true;
        int lMax = Integer.parseInt(String.valueOf(l) + String.valueOf(maxDigit));
        int maxL = Integer.parseInt(String.valueOf(maxDigit) + String.valueOf(l));
        return lMax >= maxL;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

