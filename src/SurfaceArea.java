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

class Result {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int totalArea = 0;
        int m = A.size(), n = A.get(0).size();
        int topViewArea = m * n, bootomViewArea = topViewArea;
        int leftViewArea = 0, rightViewArea = 0;
        int northviewArea = 0, southViewArea = 0;

        // top + bottom
         totalArea += topViewArea + bootomViewArea;
        // north + south
        for (int i = 0; i <A.get(0).size() ; i++) {
            northviewArea += A.get(0).get(i);
            southViewArea += A.get(m-1).get(i);
        }

        for (int i = 1; i < A.size() ; i++) {
            for (int j = 0; j < A.get(0).size() ; j++) {
                northviewArea += (A.get(i).get(j) > A.get(i-1).get(j)) ? (A.get(i).get(j) - A.get(i-1).get(j)):0;
                southViewArea += (A.get(m - i- 1).get(j) > A.get(m-i).get(j)) ? A.get(m-i-1).get(j) - A.get(m-i).get(j):0;
            }
        }
        totalArea += northviewArea + southViewArea;
        //left + right

        for (int i = 0; i < A.size() ; i++) {
            leftViewArea +=A.get(i).get(0);
            rightViewArea +=A.get(i).get(n-1);
        }

        for (int i = 1; i < A.get(0).size() ; i++) {
            for (int j = 0; j <A.size() ; j++) {
                leftViewArea += A.get(j).get(i) > A.get(j).get(i-1)? A.get(j).get(i) - A.get(j).get(i-1):0;
                rightViewArea += A.get(j).get(n-i-1) > A.get(j).get(n-i)? A.get(j).get(n-i-1) - A.get(j).get(n-i):0;
            }
        }
        totalArea +=  leftViewArea + rightViewArea;

        return totalArea;
    }

}

public class SurfaceArea {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);
        System.out.println(result);

        bufferedReader.close();

    }
}
