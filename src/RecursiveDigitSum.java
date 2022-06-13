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

class RecursiveDigitResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here

        if (n.length() == 1) return Integer.valueOf(n);
        long sum = 0;
        int s = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Character.getNumericValue(n.charAt(i));
        }
        sum =sum*k;
        s = superDigit(String.valueOf(sum),1);
        return s;

    }



}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitResult.superDigit(n, k);
        System.out.println(result);

        bufferedReader.close();

    }
}
