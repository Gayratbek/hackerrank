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

class EquilizetheArrayResult {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
        // Write your code here

        int max = 0;
        Map<String,Integer> maxValues = new HashMap<String,Integer>();

        for (int i = 0; i <arr.size() ; i++) {
            for (int j = i+1; j <arr.size() ; j++) {
                if (arr.get(i) == arr.get(j)) {
                    if (maxValues.containsKey(String.valueOf(arr.get(i)))){
                        maxValues.put(String.valueOf(arr.get(i)),Integer.valueOf(maxValues.get(String.valueOf(arr.get(i)))) + 1);
                    }
                    else maxValues.put(String.valueOf(arr.get(i)),1);
                }
            }
        }

        String maxkey = String.valueOf(arr.get(0));
        for (String key:maxValues.keySet()) {
            if (maxValues.get(key) > max ) {
                max = maxValues.get(key);
                maxkey = key;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.size() ; i++) {
            if (!String.valueOf(arr.get(i)).equals(maxkey)){
                count++;
            }
        }



        return count;

    }

}

public class EquilizetheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EquilizetheArrayResult.equalizeArray(arr);
        System.out.println(result);

        bufferedReader.close();

    }
}
