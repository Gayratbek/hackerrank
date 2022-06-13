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

class EncryptionResult {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        String s2 = new String();

        int size = s.length();
        int rowSize = (int)Math.floor(Math.sqrt(size));
        int colSize = (int)Math.ceil(Math.sqrt(size));
        while(colSize>rowSize){
            colSize--;
            if((colSize*rowSize)<size){
                colSize++;
                break;
            }
        }
        while((colSize*rowSize)<size&&(colSize>rowSize)){
            rowSize++;
        }

        for(int i =0;i<colSize;i++){

            int row = 0;
            while(row<=rowSize-1){
                if((i+row*colSize)<size)
                {
                    s2 +=  s.charAt(i+row*colSize);
                    row++;
                }     else{
                    break;
                }

            }
            s2 +=" ";

        }

//        int L = s.length();
//        int rowSize = (int)Math.floor(Math.sqrt(L));
//        int colSize = (int)Math.ceil(Math.sqrt(L));
//        int rowSize1 = 0;
//        if (rowSize*colSize < s.length()) rowSize1 = rowSize + 1;
//        else rowSize1 = rowSize;
//        char[][] s1 = new char[rowSize1][colSize];
//
//        int row = 0;
//        int col = 0;
//        for (int i = 0; i <s.length() ; i++) {
//            if (col >= colSize){
//               col = 0;
//               row++;
//            }
//            if (s.charAt(i) != ' '){
//                s1[row][col] = s.charAt(i);
//                col++;
//            }
//        }
//        String s2 = new String();
//        int j= 0;
//
//        while (j < rowSize){
//            for (int i = 0; i <s1.length ; i++) {
//                if (s1[i][j] !='\u0000'){
//                    s2 += s1[i][j];
//                }
//            }
//            s2 +=' ';
//            j++;
//        }

        return s2;

    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = EncryptionResult.encryption(s);
        System.out.println(result);

        bufferedReader.close();

    }
}
