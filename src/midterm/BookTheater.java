package midterm;

import java.util.Scanner;

public class BookTheater {

    static void printArr(int[][] arr) {
        for (int r = 1; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                String X = (arr[r][c] == 1) ? "X" : "O";
                System.out.print(X + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][N];
        while (true) {
            int row = sc.nextInt();
            int number = sc.nextInt();
            
            if (row == -1 && number == -1) {
                break;
            }

            int count = 0;
            for (int i = 0; i < arr[row].length; i++) {
                if (arr[row][i] == 0) {
                    count++;
                }
            }
            if (count >= number) {
                System.out.println("reserve");
                for (int i = 0; i < arr[row].length; i++) {
                    if (arr[row][i] == 0) {
                        arr[row][i] = 1;
                        number--;
                    }
                    if (number == 0) {
                        break;
                    }
                }
            } else {
                System.out.println("full");
            }
        }
        printArr(arr);
    }
}
