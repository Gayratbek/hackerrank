import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class PalindromeResult {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {

        int l = s.length();
        int i,j,a,b;
        for (i=0, j=l-1; i<l; i++,j--){
            if (s.charAt(i)!=s.charAt(j))
                break;
        }
        if (i>j) return -1;

        for (a = i+1, b = j;a<j && b>i+1; a++,b--){
            if (s.charAt(a)!=s.charAt(b))
                return j;
        }
        return i;
    }

}

public class palindromeSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = PalindromeResult.palindromeIndex(s);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}