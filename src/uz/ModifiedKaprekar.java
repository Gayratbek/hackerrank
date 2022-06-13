package uz;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ModifiedKaprekarResult {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        for (int i = p; i <= q ; i++) {
            int pow = (int) Math.pow(i,2);
            String st = String.valueOf(pow);

            int result = Integer.parseInt(st.substring(0,st.length()/2)) + Integer.parseInt(st.substring(st.length()/2),st.length());
            if (result == i) System.out.println(i);
        }
    }

}

public class ModifiedKaprekar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        ModifiedKaprekarResult.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
