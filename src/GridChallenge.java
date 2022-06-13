import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class GridChallengeResult {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<String> al = new ArrayList<String>();
        for (int i = 0; i <grid.size() ; i++) {
            String s = sort(grid.get(i));
            al.add(s);
        }

        for (int i = 1; i < grid.size() ; i++) {
            for (int j = 0; j < grid.get(i).length() ; j++) {
                if (al.get(i -1).charAt(j) > al.get(i).charAt(j) ) return "NO";
            }
        }
        return "YES";
    }

    private static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        return new String(ch);
    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = GridChallengeResult.gridChallenge(grid);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
