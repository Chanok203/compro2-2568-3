import java.util.Scanner;

public class StringCut_CharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (c == msg.charAt(i)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("no target character found");
            return;
        }
        if (count == msg.length()) {
            System.out.println("no output");
            return;
        }
        char prev = msg.charAt(0);
        if (prev != c) {
            System.out.print(prev);
        }
        for (int i = 1; i < msg.length(); i++) {
            char cur = msg.charAt(i);
            if (cur == c && prev != c) {
                System.out.println();
            } else if (cur != c) {
                System.out.print(cur);
            }
            prev = cur;
        }
    }
}
