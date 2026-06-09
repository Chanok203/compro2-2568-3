import java.util.Scanner;

public class PlusAndMinus {
    static int calculate(String text) {
        int idx1 = text.lastIndexOf("-");
        int idx2 = text.lastIndexOf("+");
        // * (idx1 == -1) && (idx2 == -1) 
        if (idx1 == idx2 ) {
            /**
             * ! text == "" ให้คืนค่า 0
             * ! text == "203" ให้คืนค่า 203
             */
            if (text.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(text);
        }
        /**
         * ! ถ้า text == "-542"
         * ! ได้ว่า left = "" และ right = "-542"
         * ! ทำให้ next = calculate("") = 0 และ value = -542
         * ! คืนค่า 0 + (-542) = -542
         */

        int idx = (idx1 < idx2) ? idx2 : idx1;
        
        String left = text.substring(0, idx);
        String right = text.substring(idx);

        int value = Integer.parseInt(right);
        int next = calculate(left);
        return next + value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int res = calculate(input);
        System.out.println(res);
    }
}
