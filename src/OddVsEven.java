import java.util.Scanner;

public class OddVsEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 8; i++) {
            int n = sc.nextInt();
            boolean isEven = (n % 2 == 0);
            if (isEven) {
                even += n;
            } else {
                odd += n;
            }
        }
        System.out.println("even = " + even);
        System.out.println("odd  = " + odd);
    }
}
