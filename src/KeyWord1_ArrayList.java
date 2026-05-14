import java.util.ArrayList;
import java.util.Scanner;

public class KeyWord1_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (!list.contains(word)) {
                list.add(word);
            }
        }
        for (String w : list) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}
