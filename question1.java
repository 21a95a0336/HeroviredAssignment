import java.util.Arrays;

public class question1 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5, 6, 7, 9, 10};
    int n = arr.length;
    for (int i = 1; i <= n; i++) {
      boolean f = false;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == i) {
          f = true;
          break;
        }
      }
      if (!f) {
        System.out.print(i + " ");
      }
    }
  }
}
