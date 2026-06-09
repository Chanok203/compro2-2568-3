public class Quiz3Example {

    static String toLower1(String msg) {
        int L = msg.length();
        if (L == 0) {
            return "";
        }
        char first = msg.charAt(0);
        String sub = msg.substring(1);
        String next = toLower1(sub);
        return Character.toLowerCase(first) + next;
    }

    static String toLower2(String msg) {
        int L = msg.length();
        if (L == 0) {
            return "";
        }

        char last = msg.charAt(L-1);
        String sub = msg.substring(0, L-1);
        String next = toLower2(sub);
        return next + Character.toLowerCase(last);
    }

    static String reverseCase(String msg) {
        int L = msg.length();
        if (L == 0) {
            return "";
        }

        char last = msg.charAt(L-1);
        String sub = msg.substring(0, L-1);
        String next = reverseCase(sub);

        if (Character.isLowerCase(last)) {
            return next + Character.toUpperCase(last);
        }

        return next + Character.toLowerCase(last);
    }

    public static void main(String[] args) {
        String msg = "AbcDEfG";
        String lower1 = msg.toLowerCase();

        String lower2 = "";
        for (int i = 0; i < msg.length(); i++) {
            lower2 += Character.toLowerCase(msg.charAt(i));
        }

        String lower3 = toLower1(msg);
        String lower4 = toLower2(msg);

        System.out.println(lower1);
        System.out.println(lower2);
        System.out.println(lower3);
        System.out.println(lower4);

        String msg2 = reverseCase(msg);
        System.out.println(msg);
        System.out.println(msg2);
    }
}
