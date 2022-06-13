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

class LisasWorkbookResult {

    /*
     * Complete the 'workbook' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY arr
     */

    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        int pages = 0;
        for (int i = 0; i <arr.size() ; i++) {
            pages++;
            for (int j = 1; j <= arr.get(i) ; j++) {
                if (pages == j) count++;
                if (j % k == 0) {
                    if (j!=arr.get(i))  pages++;
                }

            }

        }
        return count;

    }

}

public class LisasWorkbook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LisasWorkbookResult.workbook(n, k, arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
