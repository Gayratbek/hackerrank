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

class SequenceequationResult {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here
        List<Integer> returnvalue = new ArrayList<Integer>();

        for(int i=1;i<=p.size();i++) {
            for (int j = 0; j < p.size(); j++) {
                if (i == p.get(j)) {
                    for (int k = 0; k < p.size(); k++) {
                        if ((j + 1) == p.get(k))
//                            System.out.println(k + 1);
                                    returnvalue.add(k+1);
                    }
                }
            }
        }



//        for (int i = 0; i < p.size() ; i++) {
//            returnvalue.add(p.get(p.get(i) - 1));
//        }
        return returnvalue;

    }

}

public class Sequenceequation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = SequenceequationResult.permutationEquation(p);
        for (int i = 0; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }

        bufferedReader.close();

    }
}
