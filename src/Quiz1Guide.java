import java.util.Arrays;

public class Quiz1Guide {

    public static void main(String[] args) {
        // A - Z
        for (int i = 'A'; i <= 'Z'; i++) {
            char c = (char) i;
            System.out.print( c + " ");
        }
        System.out.println();

        // Swap
        int a = 20; // -> 30
        int b = 30; // -> 20

        int oldA = a;   // old = 20, a = 20, b = 30
        a = b;          // old = 20, a = 30, b = 30
        b = oldA;       // old = 20, a = 30, b = 20






        
        // Swap Array
        int[] arr = {20, 50, 45, 40};
        // {40, 50, 45, 20}
        int f = 1;
        int l = 2;

        int tmp = arr[f];
        arr[f] = arr[l];
        arr[l] = tmp;

        System.out.println(Arrays.toString(arr));
    }

}