import java.util.Scanner;

public class TheVoiceSU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i <= N; i++) {
            int gender = sc.nextInt();
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            // 0 = ไม่มีคนเอา, 1 = เข้าทีมที่หนึ่ง, 2 = เข้าทีมที่สอง
            // เลือกทีม
            int team = 0; 
            if (s1 >= 9 && s2 >= 9) {
                if (count1 < K && count2 < K) {
                    team = gender;
                } else if (count1 < K) {
                    team = 1;
                } else if (count2 < K) {
                    team = 2;
                }
            } else if (s1 >= 9 && count1 < K) {
                team = 1;
            } else if (s2 >= 9 && count2 < K) {
                team = 2;
            }

            // เข้าทีม
            if (team == 1) {
                count1++;
            } else if (team == 2) {
                count2++;
            }

            // พิมพ์ผลลัพธ์
            if (team != 0) {
                System.out.println(i + " " + team);
            }
        }
    }
}
