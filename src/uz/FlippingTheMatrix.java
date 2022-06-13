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

class FlippingTheMatrixResult {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here

        int sum = CaqlculateSum(matrix);

        List<List<Integer>> reversed_matrix = new ArrayList<List<Integer>>();

        for (int i = 0; i < matrix.size() ; i++) {
            for (int j = 0; j < matrix.get(i).size() ; j++) {
                List<Integer> reversed_detailed_matrix = new ArrayList<Integer>();
                reversed_detailed_matrix.add(matrix.get(i).get(matrix.get(i).size() - j));
                reversed_matrix.add(reversed_detailed_matrix);
            }
            int reversed_sum = CaqlculateSum(reversed_matrix);
            if (sum<reversed_sum) sum = reversed_sum;
        }

        return sum;

    }

    private static int CaqlculateSum(List<List<Integer>> matrix) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum += matrix.get(i).get(j);
            }
        }
        return sum;

    }

}

public class FlippingTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = FlippingTheMatrixResult.flippingMatrix(matrix);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
