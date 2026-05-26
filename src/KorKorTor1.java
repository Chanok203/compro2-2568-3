import java.util.Scanner;

class Party1 {
    String name;
    int nMember;

    String[] firstnames;
    String[] lastnames;
    int[] regions;

    Party1(String name, int nMember, Scanner sc) {
        this.name = name;
        this.nMember = nMember;

        this.firstnames = new String[nMember];
        this.lastnames = new String[nMember];
        this.regions = new int[nMember];

        for (int i = 0; i < nMember; i++) {
            this.firstnames[i] = sc.next();
            this.lastnames[i] = sc.next();
            this.regions[i] = sc.nextInt();
        }
    }

    void printInfo(int number) {
        if (number < 0) {
            System.out.println("invalid region number");
            return;
        }

        if (number == 0) {
            for (int i = 0; i < this.nMember; i++) {
                String line = String.format("%s %s %d",
                        this.firstnames[i],
                        this.lastnames[i],
                        this.regions[i]);
                System.out.println(line);
            }
            return;
        }

        boolean printed = false;
        for (int i = 0; i < this.nMember; i++) {
            if (this.regions[i] == number) {
                String line = String.format("%s %s", 
                    this.firstnames[i],
                    this.lastnames[i]
                );
                System.out.println(line);
                printed = true;
            }
        }
        if (!printed) {
            System.out.println("none");
        }
    }
}

public class KorKorTor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] names = new String[N+1];
        int[] nMembers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            names[i] = sc.next();
            nMembers[i] = sc.nextInt();
        }

        Party1[] party = new Party1[N+1];
        for (int i = 1; i <= N; i++) {
            party[i] = new Party1(names[i], nMembers[i], sc);
        }

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int partyNumber = sc.nextInt();
            int regionNumber = sc.nextInt();
            party[partyNumber].printInfo(regionNumber);
        }

    }
}
