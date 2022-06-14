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

class FairRationsResult {

    /*
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> b) {
        // Write your code here
        String returnString = new String();
        if (b.size()< 3 ) {
            returnString = "NO";
            return returnString;
        }
        int count = 0;
        int qoldiq = 0;
        for (int i = 0; i <b.size() ; i++) {
            int current = 0;
            current = b.get(i)  + qoldiq;

            if (current%2 == 1){
                qoldiq = 1;
                count +=2;
            }
            else qoldiq = 0;
        }
        if (qoldiq == 1){
            returnString = "NO";
            return returnString;
        }

          return String.valueOf(count);

    }

}

public class FairRations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = FairRationsResult.fairRations(B);
        System.out.println(result);

        bufferedReader.close();

    }
}
