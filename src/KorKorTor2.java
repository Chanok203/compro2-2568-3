import java.util.Arrays;
import java.util.Scanner;

class Precinct {
    String name;
    String[] partyNames;
    int[] counts;

    Precinct(String name, String[] partyNames) {
        this.name = name;
        this.partyNames = Arrays.copyOf(partyNames, partyNames.length);
        // this.partyNames = partyNames;
        this.counts = new int[this.partyNames.length];
    }

    void count(int partyNumber) {
        if (partyNumber < 1 || this.partyNames.length < partyNumber) {
            System.out.println("invalid number");
            return;
        }
        partyNumber -= 1;
        this.counts[partyNumber]++;
        String line = String.format("%s %d",
                this.partyNames[partyNumber],
                this.counts[partyNumber]);
        System.out.println(line);
    }

    void printInfo() {
        for (int i = 0; i < this.partyNames.length; i++) {
            String line = String.format("%d %s %d",
                    i + 1, this.partyNames[i], this.counts[i]);
            System.out.println(line);
        }
    }

    void printMax() {
        // find max
        int max = -1;
        for (int i = 0; i < this.counts.length; i++) {
            if (this.counts[i] > max) {
                max = this.counts[i];
            }
        }

        for (int i = 0; i < this.partyNames.length; i++) {
            if (max == this.counts[i]) {
                String line = String.format("%d %s %d",
                        i + 1, this.partyNames[i], this.counts[i]);
                System.out.println(line);
            }
        }
    }
}

public class KorKorTor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int nParty = sc.nextInt();
        String[] partyNames = new String[nParty];
        for (int i = 0; i < nParty; i++) {
            partyNames[i] = sc.next();
        }

        Precinct precinct = new Precinct(name, partyNames);

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int action = sc.nextInt();
            if (action == 1) {
                int P = sc.nextInt();
                precinct.count(P);
            } else if (action == 2) {
                precinct.printInfo();
            } else if (action == 3) {
                precinct.printMax();
            }
        }

    }
}
