package FanCompany;

import java.util.Scanner;

class Motor {
    double V;
    double I;
    double eff;

    Motor(double v, double i, double eff) {
        V = v;
        I = i;
        this.eff = eff / 100;
    }

    Motor(double i, double eff) {
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

public class FanCompany2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        double i = sc.nextDouble();
        double eff = sc.nextDouble();
        Motor2 motor = null;
        if (v == 220) {
            motor = new Motor2(i, eff);
        } else {
            motor = new Motor2(v, i, eff);
        }
        motor.printInfo();
    }
}
