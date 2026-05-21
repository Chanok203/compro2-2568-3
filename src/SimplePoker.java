import java.util.Scanner;

public class SimplePoker {

    static void compute(int[] cards) {
        int[] stats = new int[11];
        for (int card : cards) {
            stats[card]++;
        }

        int max = 0;
        int maxCard = -1;

        int countPair = 0;
        int p1 = -1;
        int p2 = -1;
        for (int i = 1; i < stats.length; i++) {
            if (stats[i] > max) {
                max = stats[i];
                maxCard = i;
            }
            if (stats[i] == 2) {
                countPair++;
                if (countPair == 1) {
                    p1 = i;
                } else if (countPair == 2) {
                    p2 = i;
                }
            }
        }

        if (max == 1) {
            System.out.println("No Combination");
            return;
        }

        if (max == 3) {
            System.out.println("Triple of " + maxCard);
            return;
        }

        if (max == 4) {
            System.out.println("Four of a Kind of " + maxCard);
            return;
        }

        if (max == 2 && countPair == 1) {
            System.out.println("One Pair of " + p1 );
            return;
        }

        if (max == 2 && countPair == 2) {

            for (int card : cards) {
                
                if (card == p1) {
                    // found p1 first: it's ok. break!
                    break;
                } else if (card == p2) {
                    // found p2 first then swap p1 and p2
                    int tmp = p1;
                    p1 = p2;
                    p2 = tmp;
                    break;
                }
            }

            System.out.println("Two Pair of " + p1 + " and " + p2);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numCard = 5;
        for (int i = 0; i < N; i++) {
            int[] cards = new int[numCard];
            for (int j = 0; j < numCard; j++) {
                cards[j] = sc.nextInt();
            }
            SimplePoker.compute(cards);
        }
    }
}
