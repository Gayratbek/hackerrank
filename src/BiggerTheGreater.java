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

class BiggerTheGreaterResult {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] chars = w.toCharArray();
        int i= chars.length-1;
        while(i>0){
            if(chars[i-1]>=chars[i]){
                i--;
            }else{
                int j=i;
                while(j<chars.length&&chars[j]>chars[i-1]){
                    j++;
                }
                char temp = chars[i-1];
                chars[i-1]=chars[j-1];
                chars[j-1]=temp;

                char[] newChar = new char[chars.length];
                for(int k=0;k<i;k++){
                    newChar[k]=chars[k];
                }
                int end = chars.length-1;
                for(int k=i;k<chars.length;k++){
                    newChar[k]=chars[end--];
                }
                return new String(newChar);
            }
        }
        return "no answer";

    }

}

public class BiggerTheGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = BiggerTheGreaterResult.biggerIsGreater(w);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
