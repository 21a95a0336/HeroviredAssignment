import java.util.Arrays;

public class questionone {
    public static void main(String[] args) {
        int[] arrNum = {25, 35, 12, 4, 36, 48};

        int sum = 0;
        for (int i = 0; i < arrNum.length; i++) {
            sum += arrNum[i];
            arrNum[i] = sum;
        }

        System.out.println("Cumulative Sum of Array: " + Arrays.toString(arrNum));
    }
}
