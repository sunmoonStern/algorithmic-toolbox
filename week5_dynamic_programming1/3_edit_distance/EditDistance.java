import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int[][] editDistance = new int[sLen + 1][tLen + 1];
    for (int i = 0; i <= sLen; i++) {
      editDistance[i][0] = i;
    }
    for (int j = 0; j <= tLen; j++) {
      editDistance[0][j] = j;
    }
    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= tLen; j++) {
        int currentDist = sLen + tLen;
        if (editDistance[i - 1][j] + 1 < currentDist) {
          currentDist = editDistance[i - 1][j] + 1;
        }
        if (editDistance[i][j - 1] + 1 < currentDist) {
          currentDist = editDistance[i][j - 1] + 1;
        }
        if (s.substring(i - 1, i).equals(t.substring(j - 1, j))) { // i-th character of s is s[i-1]
          if (editDistance[i - 1][j - 1] < currentDist) {
            currentDist = editDistance[i - 1][j - 1];
          }
        } else {
          if (editDistance[i - 1][j - 1] + 1 < currentDist) {
            currentDist = editDistance[i - 1][j - 1] + 1;
          }
        }
        editDistance[i][j] = currentDist;
      }
    }
    return editDistance[sLen][tLen];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
