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

class CountingSortResult {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> listreturn = new ArrayList<Integer>();

        for (int i = 0; i <= 100; i++) {
            int count = 0;
            for (int j = 0; j < arr.size(); j++) {
                  if (i == arr.get(j)){
                      count++;
                }
            }
            listreturn.add(i);
        }
        return listreturn;
    }

}

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = CountingSortResult.countingSort(arr);
        for (int eachresult:result) {
            System.out.print(eachresult +" ");

        }

        bufferedReader.close();

    }
}
