package midterm;

import java.util.Scanner;

public class MovieGoerChecker {

    static int check(int age, boolean hasParent, int rate) {
        if (age <= 0)
            return 3;
        // if (rate < 1 || 3 < rate) return 4;
        if (rate != 1 && rate != 2 && rate != 3)
            return 4;
        if (rate == 2 && age < 15 && hasParent == false)
            return 1;
        if (rate == 3 && age < 18)
            return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            boolean hasParent = sc.nextInt() == 1;
            int rate = sc.nextInt();
            int statusCode = check(age, hasParent, rate);
            System.out.println(statusCode);
        }
        sc.close();
    }
}