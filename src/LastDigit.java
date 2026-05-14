import java.util.Scanner;

public class LastDigit {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int last = number % 10;
        System.out.println(last);
    }

}
