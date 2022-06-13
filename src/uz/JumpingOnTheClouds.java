package uz;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
//        int curr = 0;
//        int Energy = 100;
//        while(curr < c.length ){
//            Energy--;
//            if(c[curr]==1)
//                Energy-=2;
//            curr += k;
//        }
        int n=c.length;

        int curr = 0;
        int e = 100;
        curr = (curr+k)%n;
        e -= 1+c[curr]*2;
        while (curr != 0) {
            curr = (curr+k)%n;
            e -= 1+c[curr]*2;
        }

        return e;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        String[] nk = scanner.nextLine().split(" ");
//
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] c = new int[n];

//        String[] cItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = scanner.nextInt();
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        System.out.println(result);

        scanner.close();
    }
}
