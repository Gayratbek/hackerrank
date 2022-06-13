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

class ServiceLaneResult {

    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        // Write your code here

        List<Integer> returnlist = new ArrayList<Integer>();
        for (int i = 0; i < cases.size() ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = cases.get(i).get(0); j <= cases.get(i).get(1); j++) {
                if (min > width.get(j)) min = width.get(j);
            }
            returnlist.add(min);
        }
        return returnlist;


    }

}

public class Servicelane {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = ServiceLaneResult.serviceLane(n, width, cases);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



        bufferedReader.close();

    }
}
