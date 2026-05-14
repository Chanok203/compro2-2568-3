import java.util.Arrays;
import java.util.Scanner;

public class StringCut_Split {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        String c = sc.nextLine();

        String[] splited = msg.split(c);
        if (splited.length == 1) {
            System.out.println("no target character found");
            return;
        }
        
        if (splited.length == 0) {
            System.out.println("no output");
            return;
        }

        for (String sub : splited) {
            if (sub.length() > 0) {
                System.out.println(sub);
            }
        }
    }
}
