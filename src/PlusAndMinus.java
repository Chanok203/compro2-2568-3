import java.util.Scanner;

public class PlusAndMinus {
    static int calculate(String text) {
        
        int idx1 = text.lastIndexOf("-");
        int idx2 = text.lastIndexOf("+");
        // * (idx1 == -1) && (idx2 == -1) 
        if (idx1 == idx2 ) {
            return Integer.parseInt(text);
        }

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
