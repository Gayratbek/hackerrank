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

class UniqueElementResult {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        for (int i = 0; i < a.size() ; i++) {
            boolean checkvalue = false;
            for (int j = 0; j < a.size(); j++) {
                if (i == j) continue;
                if (a.get(i) == a.get(j)){
                  checkvalue = true;
              }
            }
            if (!checkvalue) return a.get(i);

        }
        return 0;

    }

}

public class UniqueElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = UniqueElementResult.lonelyinteger(a);
        System.out.println(result);

        bufferedReader.close();

    }
}
