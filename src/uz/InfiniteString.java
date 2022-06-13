package uz;

import org.w3c.dom.ls.LSOutput;

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

class InfiniteStringResult {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long count  = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') count++;
        }
        long total =  (n / s.length());
        total = total * count;
        count = 0;
        if (n%s.length() >0 )
            for (int i = 0; i < n%s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    count++;

                }
            }
        total += count;


        return total;

    }

}

public class InfiniteString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = InfiniteStringResult.repeatedString(s, n);
        System.out.println(result);

        bufferedReader.close();

    }
}
