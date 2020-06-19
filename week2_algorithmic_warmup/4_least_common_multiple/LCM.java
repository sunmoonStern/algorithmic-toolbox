import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_fast(int a, int b) {
    int gcd = gcd_fast(a, b);
    long lcm = (long)a * (long)b/gcd;
    return lcm;
  }

  private static int gcd_fast(int a, int b) {
    int greaterOne = Math.max(a,b);
    int smallerOne = Math.min(a,b);
    int remainder = greaterOne % smallerOne;
    if (remainder == 0) return smallerOne;
    return gcd_fast(smallerOne, remainder);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
