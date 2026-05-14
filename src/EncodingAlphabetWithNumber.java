public class EncodingAlphabetWithNumber {


    // 1. access modifier
    // 2. static modifier
    // 3. return type
    // 4. name
    // 5. signature (aka parameters)
    static char shift(char c, int x) {
        return (char) ( (int) c + x);
    }

    public static void main(String[] args) {
        String msg = "MALEE";
        int[] arr = {1, 2, 1, 2, 3};

        String output = "";
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            int x = arr[i];
            output += shift(c, x);
        }
        System.out.println(output);
    }
}
