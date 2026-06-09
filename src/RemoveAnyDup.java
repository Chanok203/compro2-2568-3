import java.util.Scanner;
/*
removeAnyDup = f

f("MONOTONE")
= f("MONOTON")       + E  (เก็บ E)
= f("MONOTO")        + E  (ปล่อย N)
= f("MONOT")         + E  (ปล่อย O)
= f("MONO")      + T + E  (เก็บ T)
= f("MON")       + T + E  (ปล่อย O)
= f("MO")    + N + T + E  (เก็บ N)
= f("M") + O + N + T + E  (เก็บ O)
= M      + O + N + T + E  (เข้า break point และคืนค่า M)
= MONTE
*/
public class RemoveAnyDup {
    String removeAnyDup(String str) {
        int L = str.length();
        /** 
         * ! กรณีที่เป็น "" -> ""
         * ! กรณี "M" -> "M", "A" -> "A"
         */
        if (L <= 1) {
            return str;
        }
        /**
         * ! ตัดตัวอักษรสุดท้ายออก และ พิจารณาว่าจะเก็บไว้หรือไม่
         */
        String sub = str.substring(0, L - 1); // * ข้อความที่เหลือ (ตัดตัวท้ายออก)
        char last = str.charAt(L - 1); // * ตัวอักษรสุดท้าย
        String next = removeAnyDup(sub); // ! ส่งไปทำซ้ำ จนเข้า break point
        if (sub.indexOf(last) == -1) {
            return next + last; // ! เก็บ
        }
        return next; // ! ปล่อย
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        RemoveAnyDup remover = new RemoveAnyDup();
        String result = remover.removeAnyDup(str);
        System.out.print(result);
    }

}
