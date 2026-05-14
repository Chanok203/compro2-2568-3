import java.util.Scanner;

public class TheVoiceSU_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 0 -> ไม่ใช้, 1 = จำนวนคนทีมหนึ่ง, 2 = จำนวนคนทีมสอง
        int[] count = new int[3];

        for (int i = 1; i <= N; i++) {
            int gender = sc.nextInt(); // 1, 2
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();

            if (count[1] >= K) {
                s1 = 0;
            }

            if (count[2] >= K) {
                s2 = 0;
            }

            int team = 0;
            if (s1 >= 9 && s2 >= 9) {
                team = gender;
            } else if (s1 >= 9) {
                team = 1;
            } else if (s2 >= 9) {
                team = 2;
            }

            if (team != 0) {
                count[team]++;
                System.out.println(i + " " + team);
            }
        }
    }
}
