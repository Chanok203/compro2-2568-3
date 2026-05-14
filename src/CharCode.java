import java.util.Scanner;

public class CharCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  =======================
        String msg = sc.next(); // "A"
        char c = msg.charAt(0); // 'A'
        int code = (int) c; // 65
        System.out.println(code);

        // =========================
        char c2 = sc.next().charAt(0);
        int code2 = c2;
        System.out.println(code2);
    }
}
