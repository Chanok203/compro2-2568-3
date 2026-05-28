package midterm;

import java.util.ArrayList;
import java.util.Scanner;

public class InnerText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        String x = sc.next();
        int lenX = x.length();
        ArrayList<String> list = new ArrayList<>();

        int idx1 = msg.indexOf(x);
        int idx2 = msg.indexOf(x, idx1+lenX);

        if (idx1 == -1 || idx2 == -1) {
            System.out.println(0);
            return;
        }

        while (true) {
            String text = msg.substring(idx1+lenX, idx2);
            // System.out.println(text);
            list.add(text);

            idx1 = msg.indexOf(x, idx2+lenX);
            if (idx1 == -1) {
                break;
            }
            idx2 = msg.indexOf(x, idx1+lenX);
            if (idx2 == -1) {
                break;
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i);
            if (text.length() == 0) {
                text = "_";
            }
            System.out.println((i+1) + " " + text);
        }
    }
}
