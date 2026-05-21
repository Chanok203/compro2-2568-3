import java.util.Scanner;

public class KeyWord2 {

    // find word in array of words
    static int find(String[] words, int N, String word) {
        for (int i = 0; i < N; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        int[] stats = new int[N];
        int count = 0;

        int max = -1;
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            int idx = find(words, count, word);

            if (idx == -1) {
                // add new word to array
                words[count] = word;
                stats[count]++;
                idx = count;
                count++;
                System.out.print(word + " ");
            } else {
                // count old word
                stats[idx]++;
            }

            if (stats[idx] > max) {
                // check is max
                max = stats[idx];
            }
        }

        System.out.println();
        System.out.print(max);
        for (int i = 0; i < count; i++) {
            if (stats[i] == max) {
                System.out.print(" " + words[i]);
            }
        }
        System.out.println();

    }
}
