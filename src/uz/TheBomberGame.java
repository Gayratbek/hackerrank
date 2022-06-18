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

class TheBomberGameResult {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        List<String> replacedgrid = new ArrayList<String>();

        if (n == 1) return grid;
        else if (n%2 == 0) {
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(i).length(); j++) {
                    grid.set(i, grid.get(i).replace(grid.get(i).charAt(j), 'O'));
                }
            }
            return grid;
        }
        else  if (n == 3) {
            for (int i = 0; i < grid.size(); i++) {
                replacedgrid.add(grid.get(i));
                for (int j = 0; j < grid.get(i).length(); j++) {
                    replacedgrid.set(i, replacedgrid.get(i).replace(replacedgrid.get(i).charAt(j), 'O'));
                }

            }

            for (int i = 0; i < grid.size() ; i++) {
                for (int j = 0; j < grid.get(i).length() ; j++) {
                    if (grid.get(i).charAt(j) != '.') {
                        String changed  = replace(replacedgrid.get(i),j,'.');
                        replacedgrid.set(i,replace(replacedgrid.get(i),j,'.'));
                        if (i>0) replacedgrid.set(i - 1, replace(replacedgrid.get(i-1),j,'.'));
                        if (i < replacedgrid.size() -1) replacedgrid.set(i + 1, replace(replacedgrid.get(i+1),j,'.'));
                        if (j < replacedgrid.get(i).length() -1) replacedgrid.set(i, replace(replacedgrid.get(i),j + 1,'.'));
                        if (j>0)replacedgrid.set(i, replace(replacedgrid.get(i),j - 1,'.'));
                    }
                }
            }
            return replacedgrid;
        }
        else {




        }



        return grid;

    }
    public static String replace(String str, int index, char replace){
        if(str==null){
            return str;
        }else if(index<0 || index>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }

}

public class TheBomberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = TheBomberGameResult.bomberMan(n, grid);
        for (String each : result) {
            System.out.println(each);
        }

        bufferedReader.close();

    }
}
