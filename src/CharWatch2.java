import java.util.Scanner;

public class CharWatch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] chars = new char[3];
        int[] counts = new int[3];
        for (int i = 0; i < 3; i++) {
            chars[i] = sc.next().charAt(0);
        }

        int K = sc.nextInt();
        sc.nextLine();
        String[] msgs = new String[K];
        for (int i = 0; i < K; i++) {
            msgs[i] = sc.nextLine();
        }

        int N = sc.nextInt();
        int[] indices = new int[N];
        for (int i = 0; i < N; i++) {
            indices[i] = sc.nextInt();
        }



        
        for (int index: indices) {
            int idx = index - 1;
            for (String msg : msgs) {
                if (idx < 0 || msg.length() <= idx) {
                    continue;
                }

                char c = msg.charAt(idx);
                for (int j = 0; j < 3; j++) {
                    if (c == chars[j]) {
                        counts[j]++;
                        break;
                    }
                }
            }
        }
        for (int count : counts) {
            System.out.println(count);
        }
    }
}
