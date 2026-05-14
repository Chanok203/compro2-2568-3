import java.util.Scanner;

public class CharWatch1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char char1 = scan.next().charAt(0);
        char char2 = scan.next().charAt(0);
        char char3 = scan.next().charAt(0);

        String msg = scan.next();
        int N = scan.nextInt();
        int[] indices = new int[N];
        for (int i = 0; i < N; i++) {
            indices[i] = scan.nextInt();
        }

        char[] chars = {char1, char2, char3, '-'};
        int[] counts = new int[4];

        for (int idx : indices) {
            if (idx < 1 || msg.length() < idx) {
                counts[3]++;
                continue;
            }

            char c = msg.charAt(idx - 1);
            for (int i = 0; i < 3; i++) {
                if (c == chars[i]) {
                    counts[i]++;
                    break;
                }
            }
        }

        for (int count : counts) {
            System.out.println(count);
        }
    }
}
