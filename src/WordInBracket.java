import java.util.Scanner;

public class WordInBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        int count = 0;
        int idx = msg.indexOf("{");
        while (idx != -1) {
            int idx1 = msg.indexOf("{", idx + 1);
            int idx2 = msg.indexOf("}", idx + 1);
            // if (idx2 != -1 && (idx1 == -1 || idx2 < idx1)) {
            if (
                (idx2 != -1 && idx1 == -1)
                || (idx2 != -1 && idx2 < idx1)
                
            ) {
                String word = msg.substring(idx + 1, idx2);
                if (word.length() > 0) {
                    count++;
                    System.out.println(word);
                }
            }
            idx = idx1;
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }
}
