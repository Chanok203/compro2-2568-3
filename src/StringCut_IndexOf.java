import java.util.Scanner;

public class StringCut_IndexOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        int idx = msg.indexOf(c);
        if (idx == -1) {
            System.out.println("no target character found");
            return;
        }

        boolean printed = false;
        while (idx != -1) {
            String left = msg.substring(0, idx);
            msg = msg.substring(idx+1);

            if (left.length() > 0) {
                System.out.println(left);
                printed = true;
            }
            idx = msg.indexOf(c);
        }
        if (msg.length() > 0) {
            System.out.println(msg);
            printed = true;
        }
        if (!printed) {
            System.out.println("no output");
        }
    }
}
