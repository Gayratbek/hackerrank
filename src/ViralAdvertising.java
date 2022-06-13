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

class ViralAdvertisingResult {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
        // Write your code here
        int received = 5;
        int sum=0;
        while(n-- >0){
            int remaining = received/2;
            sum+=remaining;
            received = remaining*3;
        }
        return sum;
    }

}

public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = ViralAdvertisingResult.viralAdvertising(n);

        System.out.println(result);
        bufferedReader.close();

    }
}
