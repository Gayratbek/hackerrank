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

class CavitymapResult {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        for (int i = 1; i < grid.size() -1 ; i++) {
            String newString = new String();
            for (int j = 0; j < grid.get(i).length() ; j++) {
                if ((j ==0 || j ==grid.get(i).length() -1) ){
                    newString +=grid.get(i).charAt(j);
                }
                else {
                    if ((int) grid.get(i).charAt(j) - '0' > (int )grid.get(i).charAt(j - 1) -'0' &&
                            (int ) (grid.get(i).charAt(j) - '0') > (int) (grid.get(i).charAt(j + 1) -'0') &&
                            (int) grid.get(i).charAt(j) - '0' > (int )grid.get(i-1).charAt(j) -'0' &&
                            (int) grid.get(i).charAt(j) - '0' > (int )grid.get(i+1).charAt(j) -'0'
                    )
                    {
                        newString +="X";
                    }
                    else newString +=grid.get(i).charAt(j);
                }

            }
            grid.set(i,newString);
        }
       return grid;
    }

}

public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = CavitymapResult.cavityMap(grid);
        for (String eachresult:result) {
            System.out.println(eachresult);
        }
        bufferedReader.close();

    }
}
