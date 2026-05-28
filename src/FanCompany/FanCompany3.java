package FanCompany;

import java.util.Scanner;

class Blade2 {
    int size; // 16, 18, 20, 22, 24
    int number; // 3 4 5
    int angle; // 27 30 33
    double hp; // >0
    boolean valid;

    Blade2(int size, int number, int angle, double hp) {
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

class Motor2 {
    double V;
    double I;
    double eff;

    Motor2(double v, double i, double eff) {
        V = v;
        I = i;
        this.eff = eff / 100;
    }

    Motor2(double i, double eff) {
        this(220, i, eff);
    }

    double horsepower() {
        return (this.V * this.I * this.eff) / 746;
    }

    void printInfo() {
        String line = String.format(
                "%s %s %s %.2f",
                this.V,
                this.I,
                this.eff,
                this.horsepower());
        System.out.println(line);
    }
}

class ElectricFan {
    static int count = 0;

    int productID;
    Blade2 blade;
    Motor2 motor;
    boolean status;

    ElectricFan(Blade2 blade, Motor2 motor) {
        this.blade = blade;
        this.motor = motor;
        ElectricFan.count++;
        this.productID = ElectricFan.count;
        this.status = this.motor.horsepower() >= this.blade.hp;
    }

    boolean changeBlade(Blade2 blade) {
        this.blade = blade;
        this.status = this.motor.horsepower() >= this.blade.hp;
        return this.status;
    }

    boolean changeMotor(Motor2 motor) {
        this.motor = motor;
        this.status = this.motor.horsepower() >= this.blade.hp;
        return this.status;
    }

    void printInfo() {
        String line = String.format(
                "%d %d %s %s %.2f %s",
                this.productID,
                this.blade.size,
                this.blade.hp,
                this.motor.I,
                this.motor.horsepower(),
                this.status);
        System.out.println(line);
    }

}

public class FanCompany3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size, numb, angle;
        double hp, v, i, eff;
        Blade2 ablade = null;
        Motor2 motor = null;
        ElectricFan eFan = null;
        for (int index = 0; index < n; index++) {
            int cmd = sc.nextInt();
            if (cmd == 0) {
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade2(size, numb, angle, hp);
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor2(v, i, eff);
                eFan = new ElectricFan(ablade, motor);
            } else if (cmd == 1) {
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade2(size, numb, angle, hp);
                eFan.changeBlade(ablade);
            } else if (cmd == 2) {
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor2(v, i, eff);
                eFan.changeMotor(motor);
            }
            eFan.printInfo();
        }
    }

}
