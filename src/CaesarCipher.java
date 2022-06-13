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

class CaesarCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int qoldiq = k % alphabet.length();
        String rotatedalphabet  = alphabet.substring(qoldiq,alphabet.length());
        rotatedalphabet = rotatedalphabet + alphabet.substring(0,qoldiq);
        String news = new String();

        for (int i = 0; i < s.length(); i++) {
            boolean found  = false;
            for (int j = 0; j <alphabet.length() ; j++) {
                int curposition = -1;
                boolean bigletter = false;
                if (s.charAt(i) == alphabet.charAt(j)) curposition = j;
                else {
                    if (s.charAt(i) == Character.toUpperCase(alphabet.charAt(j))) {
                        curposition = j;
                        bigletter = true;
                    }
                }
                if (curposition >= 0) {
                   found = true;
                   if (bigletter) news = news + Character.toUpperCase(rotatedalphabet.charAt(curposition));
                   else news = news + rotatedalphabet.charAt(curposition);

                }
            }
         if (!found) news = news + s.charAt(i);

        }
        return news;

    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipherResult.caesarCipher(s, k);
        System.out.println(result);
        bufferedReader.close();

    }
}
