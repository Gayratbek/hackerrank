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

//class Result {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

//    public static long strangeCounter(long t) {
//        // Write your code here
//        long start = 4 ;
//        int count = 0;
//        for (int i = 1; i <= t ; i++) {
//
//            if (start == 1  ){
//                start = count*2;
//                count = 1;
//            }
//            else {
//                count++;
//                start --;
//            }
//        }
//
//        return start;
//
//    }

//}

public class StrangeCounter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        long curr = 3;
        while (t > curr) {
            t -= curr;
            curr *= 2;
        }
        System.out.println(curr-t+1);
   
    }
}
