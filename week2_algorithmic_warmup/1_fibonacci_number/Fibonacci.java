import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_table(int n) {
    int max_fib = 46;
    long[] fib_table = new long[max_fib];
    fib_table[0] = 0L;
    fib_table[1] = 1L;
    for (int i = 2; i <= n; i++) {
      fib_table[i] = fib_table[i-1] + fib_table[i-2];
    }
    return fib_table[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_table(n));
  }
}
