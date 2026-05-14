import java.util.Scanner;

public class AgeReport {

    static int reportAge(
            int[] IDs,
            int[] ages,
            int Y1,
            int Y2) {
        int count = 0;
        int L = IDs.length;
        for (int i = 0; i < L; i++) {
            int id = IDs[i];
            int age = ages[i];
            if (age < Y1 || Y2 < age) {
                continue;
            }
            System.out.println(id);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] IDs = new int[N];
        int[] ages = new int[N];
        for (int i = 0; i < N; i++) {
            IDs[i] = sc.nextInt();
            ages[i] = sc.nextInt();
        }
        int Y1 = sc.nextInt();
        int Y2 = sc.nextInt();
        int count = AgeReport.reportAge(IDs, ages, Y1, Y2);
        String line = String.format(
                "There are %d persons in age range of %d to %d",
                count, Y1, Y2);
        System.out.println(line);
    }
}
