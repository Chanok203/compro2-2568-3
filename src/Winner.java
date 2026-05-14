import java.util.Scanner;

public class Winner {

    /**
     * 0 = น้ำ
     * 1 = เรือ
     * 2 = เรือที่โดนยิง
     * 3 = น้ำที่โดนยิง
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] map = new int[R][C];

        int battleship = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] = sc.nextInt();
                battleship += map[r][c];
            }
        }
        int[] counts = new int[5];
        //   0    1       2          3       4
        // {hit, miss, hitAgain, missAgain, out}
        int firstHit = -1;
        int lastHit = -1;
        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            boolean validR = (0 <= r) && (r < R);
            boolean validC = (0 <= c) && (c < C);
            if (!validR || !validC) {
                counts[4]++; // out++
            } else if (map[r][c] == 0) {
                counts[1]++; // miss++
                map[r][c] = 3;
            } else if (map[r][c] == 1) {
                counts[0]++; // hit++
                battleship--;
                map[r][c] = 2;
                lastHit = k + 1;
                if (firstHit == -1) {
                    firstHit = k + 1;
                }
            } else if (map[r][c] == 2) {
                counts[2]++; // hitAgain++
            } else if (map[r][c] == 3) {
                counts[3]++; // missAgain++
            }
        }
        for (int c : counts) {
            System.out.println(c);
        }
        if (battleship > 0) {
            System.out.println("battleship " + firstHit);
        } else {
            System.out.println("attacker " + lastHit);
        }
    }
}
