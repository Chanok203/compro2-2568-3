import java.util.Scanner;

public class UnderLineWithParameter {

    static void underLine() {
        underLineWithParams(20);
    }

    static void underLineWithParams(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            int n = sc.nextInt();
            System.out.println(word);
            underLineWithParams(n);
        }
    }
}
