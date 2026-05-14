import java.util.Scanner;

public class TheVoiceSU_2 {
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
            int team = 0;
            if (s1 >= 9 && s2 >= 9) {
                if (count[1] < K && count[2] < K) {
                    team = gender;
                } else if (count[1] < K) {
                    team = 1;
                } else if (count[2] < K) {
                    team = 2;
                }
            } else if (s1 >= 9 && count[1] < K) {
                team = 1;
            } else if (s2 >= 9 && count[2] < K) {
                team = 2;
            }

            if (team != 0) {
                count[team]++;
                System.out.println(i + " " + team);
            }
        }
    }
}
