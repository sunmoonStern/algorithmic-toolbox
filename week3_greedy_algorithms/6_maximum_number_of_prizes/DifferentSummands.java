import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int currentInt = 1;
        int currentSum = n;
        while (currentSum >= 2 * currentInt + 1) {
            currentSum -= currentInt;
            summands.add(currentInt);
            currentInt += 1;
        }
        while (true) {
            if (currentSum == currentInt) {
                currentSum -= currentInt;
                summands.add(currentInt);
                break;
            }
            currentInt += 1;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

