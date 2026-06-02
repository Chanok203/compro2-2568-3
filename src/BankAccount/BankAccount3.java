package BankAccount;

import java.util.Scanner;

class Account3 {
    String name;
    String code;
    double balance;
    boolean active;

    Account3(String name, String code, double balance) {
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

class Saving3 extends Account3 {
    String id; // null
    String tel; // null
    boolean promptPay;

    Saving3(String name, String code, double balance) {
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

class FixedDeposit extends Account3 {
    double fixedAmount;

    FixedDeposit(String name, String code, double balance, double fixedAmount) {
        super(name, code, balance);
        this.fixedAmount = fixedAmount;
        System.out.println("FixedDeposit account with " + fixedAmount);
    }

    @Override
    boolean deposit(double money) {
        if (money < this.fixedAmount) {
            System.out.print("deposit less than " + this.fixedAmount + " ");
            return false;
        }
        return super.deposit(money);
    }
}

class CurrentAccount extends Account3 {
    double overDraft;

    CurrentAccount(String name, String code, double balance, double overDraft) {
        super(name, code, balance);
        this.overDraft = overDraft;
        System.out.println("Current account with overdraft " + overDraft);
    }

    @Override
    boolean withdrawn(double money) {
        if (!this.active) {
            return false;
        }
        if (this.balance - money < -this.overDraft) {
            return false;
        }
        this.balance -= money;
        System.out.print(this.balance + " ");
        if (this.balance < 0) {
            System.out.print("overdraft ");
        }
        return true;
    }
}

public class BankAccount3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Saving3 sAcc = null;
        FixedDeposit fAcc = null;
        CurrentAccount cAcc = null;
        for (int t = 1; t <= 3; t++) {
            String name = scan.nextLine();
            String code = scan.nextLine();
            double money1 = scan.nextDouble();
            if (t == 1) {
                scan.nextLine();
                sAcc = new Saving3(name, code, money1);
            } else if (t == 2) {
                double money2 = scan.nextDouble();
                scan.nextLine(); // Skip the remainder of the double line.
                fAcc = new FixedDeposit(name, code, money1, money2);

            } else if (t == 3) {
                double money2 = scan.nextDouble();
                scan.nextLine(); // Skip the remainder of the double line.
                cAcc = new CurrentAccount(name, code, money1, money2);
            }
        }
        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) {
            double amount;
            int accId = scan.nextInt();
            Account3 ac;
            if (accId == 1) {
                ac = sAcc;
            } else if (accId == 2) {
                ac = fAcc;
            } else {
                ac = cAcc;
            }

            int menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    ac.printInfo();
                    break;
                }
                case 2 -> {
                    double balance = ac.checkBalance();
                    System.out.println(balance);
                    break;
                }
                case 3 -> {
                    ac.closeAccount();
                    break;
                }
                case 4 -> {
                    amount = scan.nextDouble();
                    boolean result = ac.deposit(amount);
                    System.out.println(result);
                    break;
                }
                case 5 -> {
                    amount = scan.nextDouble();
                    boolean result = ac.withdrawn(amount);
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
