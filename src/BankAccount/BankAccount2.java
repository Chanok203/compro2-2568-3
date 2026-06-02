package BankAccount;

import java.util.Scanner;

class Account2 {
    String name;
    String code;
    double balance;
    boolean active;

    Account2(String name, String code, double balance) {
        this.name = name;
        this.code = code;
        this.balance = balance;
        this.active = true;
        System.out.println("Open account");
    }

    void printInfo() {
        String line = String.format(
                "%s, %s, %s, %s",
                this.name,
                this.code,
                this.balance,
                (this.active) ? "active" : "inactive");
        System.out.println(line);
    }

    double checkBalance() {
        return this.balance;
    }

    void closeAccount() {
        this.active = false;
        this.printInfo();
    }

    boolean deposit(double money) {
        if (!this.active) {
            return false;
        }
        this.balance += money;
        System.out.print(this.balance + " ");
        return true;
    }

    boolean withdrawn(double money) {
        if (!this.active) {
            return false;
        }
        if (this.balance < money) {
            return false;
        }
        this.balance -= money;
        System.out.print(this.balance + " ");
        return true;
    }
}

class Saving2 extends Account3 {
    String id; // null
    String tel; // null
    boolean promptPay;

    Saving2(String name, String code, double balance) {
        super(name, code, balance);
        this.promptPay = false;
        System.out.println("Saving account");
    }

    @Override
    void printInfo() {
        super.printInfo();
        if (!promptPay) {
            System.out.println("no PromptPay");
        } else {
            String line = "PromptPay";
            if (this.id != null) {
                line += ", " + this.id;
            }
            if (this.tel != null) {
                line += ", " + this.tel;
            }
            System.out.println(line);
        }
    }

    boolean openPromptPay(int type, String value) {
        if (type == 1 && value.length() == 13) {
            this.promptPay = true;
            this.id = value;
            return true;
        } else if (type == 2 && value.length() == 10) {
            this.promptPay = true;
            this.tel = value;
            return true;
        }
        return false;
    }

}

public class BankAccount2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String code = scan.nextLine();
        double money = scan.nextDouble();
        Saving2 ac = new Saving2(name, code, money);
        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) {
            int action = scan.nextInt();
            if (action == 1) {
                ac.printInfo();
            } else if (action == 2) {
                double balance = ac.checkBalance();
                System.out.println(balance);
            } else if (action == 3) {
                ac.closeAccount();
            } else if (action == 4) {
                money = scan.nextDouble();
                boolean result = ac.deposit(money);
                System.out.println(result);
            } else if (action == 5) {
                money = scan.nextDouble();
                boolean result = ac.withdrawn(money);
                System.out.println(result);
            } else if (action == 6) {
                int type = scan.nextInt();
                String value = scan.nextLine().strip();
                boolean result = ac.openPromptPay(type, value);
                System.out.println(result);
            }
        }
    }
}
