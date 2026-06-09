import java.util.Scanner;

public class SeparateCharactersAndNumbers {
    /*
     ! f("A1B2C3") -> "ABC321"
     * f("A1B2C3")
     * = A + f("1B2C3")
     * = A + f("B2C3") + 1
     * = A + B + f("2C3") + 1
     * = A + B + f("C3") + 2 + 1
     * = A + B + C + f("3") + 2 + 1
     * = A + B + C + 3 + 2 + 1
     * = ABC321
     */
    static String split(String msg) {
        int L = msg.length();
        if (L == 1) {
            return msg;
        }
        char first = msg.charAt(0);
        String sub = msg.substring(1);
        String next = split(sub);

        if (Character.isDigit(first)) {
            return next + first;
        }
        return first + next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        String res = split(msg);
        System.out.println(res);
    }

}
