import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        int mid = (int) Math.floor(left + (right - left)/2d);
        int leftMajorityElement = getMajorityElement(a, left, mid);
        int rightMajorityElement = getMajorityElement(a, mid, right);
        System.out.println("left = " + left + " right = " + right);
        System.out.println("left majority" + leftMajorityElement);
        System.out.println("right majority" + rightMajorityElement);
        if (leftMajorityElement == -1 && rightMajorityElement == -1) {
            return -1;
        } else {
            int leftCount = getCount(a, left, right, leftMajorityElement);
            int rightCount = getCount(a, left, right, rightMajorityElement);
            int largerCount = Math.max(leftCount, rightCount);
            if (largerCount > a.length/2d) {
                if (leftCount > rightCount) {
                    return leftMajorityElement;
                } else {
                    return rightMajorityElement;
                }
            } else {
                return -1;
            }
        }
    }

    static int getCount(int[] a, int left, int right, int x) {
        int count = 0;
        if (x < 0) return count;
        for (int i = left; i < right; i++) {
            if (a[i] == x) count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

