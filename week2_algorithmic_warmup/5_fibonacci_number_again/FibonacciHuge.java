import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHugeFast(long n, long m) {
        int max_fib = 1000000;
        long[] fib_table = new long[max_fib];
        fib_table[0] = 0L;
        fib_table[1] = 1L;
        int period = 0;
        for (int i = 2; i <= max_fib; i++) {
            fib_table[i] = (fib_table[i-1] + fib_table[i-2]) % m;
            if (fib_table[i] == 1L && fib_table[i-1] == 0L) {
                period = i-1;
                break;
            }
        }
        int remainder = (int)(n % (long)period);

        return fib_table[remainder];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

