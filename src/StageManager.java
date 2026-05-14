import java.util.Arrays;
import java.util.Scanner;

public class StageManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = 10;
        char[] arr = new char[L];
        for (int i = 0; i < L; i++) {
            arr[i] = (char) ('A' + i);
        }
        // System.out.println(Arrays.toString(arr));

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt() - 1;
            int B = sc.nextInt() - 1;

            boolean isValidA = (0 <= A) && (A < L);
            boolean isValidB = (0 <= B) && (B < L);
            boolean isValid = isValidA && isValidB;

            if (isValid) {
                char tmp = arr[A];
                arr[A] = arr[B];
                arr[B] = tmp;
            }
            System.out.println(isValid);
            // System.out.println(Arrays.toString(arr));
        }
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}