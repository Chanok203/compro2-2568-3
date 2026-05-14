import java.util.Scanner;

public class KeyWord1_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            boolean isDup = false;
            for (int j = 0; j < count; j++) {
                if (word.equalsIgnoreCase(arr[j])) {
                    isDup = true;
                    break;
                }
            }
            if (!isDup) {
                arr[count++] = word;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
