package midterm;

import java.util.Scanner;

class Tree {
    public int w;
    public int h;
    public int n;

    public Tree(int w, int h) {
        this.w = w;
        this.h = h;
        this.n = 15 * (w + h);
        this.printInfo();
    }

    public void grow(int P) {
        this.w += P;
        if (this.w > 30) {
            this.w = 30;
        }
    }

    public void leaveTree(int K) {
        this.n -= K;
        if (this.n < 0) {
            this.n = 0;
        } 
    }

    public void reproductive(int D) {
        this.n += (D*this.w*this.h/14) + (D*this.n/7);
    }

    public void printInfo() {
        String line = String.format(
            "Width %d, Height %d, Bird %d",
            this.w, this.h, this.n
        );
        System.out.println(line);
    }

}

public class BirdyHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        Tree tree = new Tree(w, h);

        while (true) {
            int C = sc.nextInt();
            if (C == 0) {
                break;
            } else if (C == 1) {
                int K = sc.nextInt();
                tree.leaveTree(K);
            } else if (C == 2) {
                int D = sc.nextInt();
                tree.reproductive(D);
            } else if (C == 3) {
                int P = sc.nextInt();
                tree.grow(P);
            }

            tree.printInfo();
        }
    }
}
