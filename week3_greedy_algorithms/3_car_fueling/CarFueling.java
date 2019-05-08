import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0; // distance represented by index of stops
        int lastRefill = 0; // distance represented by index of stops
        int n = stops.length;
        int modifiedStops[] = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            if (i == 0) {
                modifiedStops[i] = 0;
            } else if (i == n + 1) {
                modifiedStops[i] = dist;
            } else {
                modifiedStops[i] = stops[i-1];
            }
        }
        while (currentRefill <= n) {
            while (modifiedStops[currentRefill+1] - modifiedStops[lastRefill] <= tank) {
                currentRefill += 1;
                if (currentRefill == n+1) break;
            }
            if (currentRefill == lastRefill) return -1;
            if (currentRefill == n + 1) return numRefills;
            lastRefill = currentRefill;
            numRefills += 1;
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
