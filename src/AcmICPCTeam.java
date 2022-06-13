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

class ACMPCMTeamResult {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        int matched_topics = 0;
        int matched_covered = 0;
        int teams = 0;

        for (int i = 0; i < topic.size(); i++) {
            String text = topic.get(i);
            for (int j = i + 1; j < topic.size() ; j++) {

                matched_topics = 0;
                for (int k = 0; k < text.toCharArray().length ; k++) {
                    if (topic.get(i).charAt(k) - '0' > 0 || topic.get(j).charAt(k) - '0' > 0 ){
                        matched_topics++;
                    }
                    if (matched_topics == matched_covered) teams ++ ;
                    else if (matched_topics>matched_covered) {
                        matched_covered = matched_topics;
                        teams = 1;
                    }


                }
            }
        }

        List<Integer> arrlist = new ArrayList<>();
        arrlist.add(matched_covered);
        arrlist.add(teams);


//        int max= 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) > max) max = list.get(i);
//        }
//
//        List<Integer> arrlist = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == max) count++;
//        }
//        arrlist.add(max);
//        arrlist.add(count);

        return arrlist;

    }

    private static int checktwotopics(String s, String s1) {
        int count  = 0;
        for (int i = 0; i < s.toCharArray().length ; i++) {
            if (s.toCharArray()[i] == '1' || s1.toCharArray()[i] == '1' ){
                count++;
            }
        }
        return count;
    }


}

public class AcmICPCTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
   
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = ACMPCMTeamResult.acmTeam(topic);

        for (int eachresult : result) {
            System.out.println(eachresult);
        }



        bufferedReader.close();
   
    }
}
