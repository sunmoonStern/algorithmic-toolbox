import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product, (long)numbers[first] * (long)numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProduct2(int[] numbers) {
        int n = numbers.length;
        int index1 = 0;
        int index2;

        for (int i = 1; i < n; ++i) {
            if (numbers[i] > numbers[index1]) index1 = i;
        }

        if (index1 == 0) index2 = 1; else index2 = 0; // if the first element is largest, the index of the second largest element is >= 1

        for (int i = 1; i < n; ++i) {
            if (numbers[i] > numbers[index2] && i != index1) index2 = i;
        }

        return (long)numbers[index1] * (long)numbers[index2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct2(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next());
        }
    }

}
