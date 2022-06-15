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

class GridSearchResult {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> g, List<String> p) {
        // Write your code here
        boolean found = false;
        boolean pfinish = false;
        int index = 0;
        int j = 0;
        for (int i = 0; i < p.size(); i++) {
            if (pfinish) continue;
            boolean finish = false;
            while (!finish) {
                if (g.get(j).contains(p.get(i))){
                   if (index == 0) {
                       index =g.get(j).indexOf(p.get(i));
                   }
                   else {
                       if (index == g.get(j).indexOf(p.get(i))){
                           found = true;
                       }
                       else {
                           found = false;
                       }
                   }
                   finish = true;
                }
                else {
                    if (index != 0) {
                        found = false;
                        finish = true;
                    }

                }
                j++;
                if (j >= g.size()){
                    pfinish = true;
                    finish = true;
                }

            }
         }

        if (found) return "YES";
        else return "NO";

    }

}

public class GridSerarch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = GridSearchResult.gridSearch(G, P);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
