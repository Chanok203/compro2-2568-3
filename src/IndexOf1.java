import java.util.Scanner;

public class IndexOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        String word = sc.nextLine();

        {
            int idx = msg.indexOf(word);
            if (idx == -1) {
                System.out.println("string not found");
            } else {
                System.out.println(idx + 1);
            }
        }

        {
            boolean found = false;
            for (int i = 0; i <= msg.length() - word.length(); i++) {
                boolean isWord = true;
                for (int j = 0; j < word.length(); j++) {
                    char a = msg.charAt(i + j);
                    char b = word.charAt(j);
                    if (a != b) {
                        isWord = false;
                        break;
                    }
                }
                if (isWord) {
                    System.out.println(i + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("string not found");
            }
        }
    }
}
