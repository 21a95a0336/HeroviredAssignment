import java.util.*;

public class question2 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
    for (int i = 0; i < arr.length; i++) {
      boolean isUnique = true;
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          isUnique = false;
          break;
        }
      }
      if (isUnique) {
        System.out.print(arr[i] + " ");
      }
    }
  }
}
