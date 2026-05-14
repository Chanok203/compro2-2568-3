import java.util.Scanner;

public class PizzaShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[3];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            arr2[i] = sc.nextInt();
        }

        int count1 = 0; // วิ่งใน arr1
        int count2 = 0; // วิ่งใน arr2
        boolean hasNext = true;

        while (hasNext) {
            int L = arr2[count2 % 3];
            // System.out.println("L=" + L);
            // System.out.print("output: ");

            int sum = 0;
            for (int i = 0; i < L; i++) {
                // System.out.print(arr1[count1] + " ");
                sum += arr1[count1];
                count1++;
                if (count1 >= N) {
                    hasNext = false;
                    break;
                }
            }
            System.out.print(sum + " ");
            count2++;
        }
    }
}
