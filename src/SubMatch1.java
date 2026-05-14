import java.util.Scanner;

public class SubMatch1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        String input = sc.nextLine();

        String[] subs = new String[3];
        for (int i = 0; i < 3; i++) {
            subs[i] = input.substring(i, i + 3);
        }

        for (String sub : subs) {
            int idx = msg.indexOf(sub);

            if (idx == -1) {
                System.out.println("No");
            } else {
                System.out.println(idx + 1);
            }
        }
    }
}