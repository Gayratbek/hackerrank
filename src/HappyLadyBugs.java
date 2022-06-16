import java.io.*;
import java.util.stream.*;

class HappyLadyBugsResult {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
        // Write your code here
        String returnvlue = new String();

        if (b.contains("_")) {
//            for (int i = 0; i < b.length(); i++) {
                returnvlue ="YES";
//            }
        }
        else
        {
            returnvlue ="NO";

        }

        return returnvlue;

    }

}

public class HappyLadyBugs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = HappyLadyBugsResult.happyLadybugs(b);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
