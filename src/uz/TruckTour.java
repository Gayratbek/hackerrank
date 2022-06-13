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



class TruckTourResult {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int sum = 0;
        for (int i = 0; i < petrolpumps.size() ; i++) {
            boolean finish = false;
            int t = i;
            while (!finish){
                sum += petrolpumps.get(t).get(0) - petrolpumps.get(t).get(1);
                if (sum<0 ) {
                    sum = 0;
                    finish = true;
                }
                else {
                    if (t + 1 == i) return i;
                    if (t +1 < petrolpumps.size() )  t++;
                    else t = 0;
                }
            }
        }
        return 0;
    }

}

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TruckTourResult.truckTour(petrolpumps);
        System.out.println(result);

        bufferedReader.close();

    }
}
