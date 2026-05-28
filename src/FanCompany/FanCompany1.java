package FanCompany;

import java.util.Scanner;

class Blade1 {
    int size; // 16, 18, 20, 22, 24
    int number; // 3 4 5
    int angle; // 27 30 33
    double hp; // >0
    boolean valid;

    Blade1(int size, int number, int angle, double hp) {
        this.size = size;
        this.number = number;
        this.angle = angle;
        this.hp = hp;

        this.valid = true;
        if (size % 2 != 0 || size < 16 || 24 < size) {
            System.out.println("invalid size");
            this.valid = false;
        }
        if (number < 3 || 5 < number) {
            System.out.println("invalid number of blades");
            this.valid = false;
        }
        if (angle % 3 != 0 || angle < 27 || 33 < angle) {
            System.out.println("invalid angle");
            this.valid = false;
        }
        if (hp <= 0) {
            System.out.println("invalid horsepower");
            this.valid = false;
        }
    }

    void printInfo() {
        String line = String.format(
                "%d %d %d %.2f %s",
                this.size,
                this.number,
                this.angle,
                this.hp,
                this.valid);
        System.out.println(line);
    }

}

public class FanCompany1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int numb = scan.nextInt();
        int angle = scan.nextInt();
        double hp = scan.nextDouble();
        Blade2 ablade = new Blade2(size, numb, angle, hp);
        ablade.printInfo();
    }
}
