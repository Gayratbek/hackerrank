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

class ClimbingLeaderboardResult {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        ArrayList<Integer> places = new ArrayList<Integer>();
        ArrayList<Integer> returnplaces = new ArrayList<Integer>();
        int place = 1;
        places.add(ranked.get(0));
        for(int i = 1; i < ranked.size();i++){
            int currPlace = place-1;
            int currScore = ranked.get(i);
            if(currScore != places.get(currPlace)){
                place++;
                places.add(currScore);
            }
        }
        int currPlace = places.size() + 1;
        for(int i = 0; i < player.size(); i++){
            currPlace = getPlace(currPlace, player.get(i), places);
            returnplaces.add(currPlace);
        }

        return returnplaces;
    }
    public static int getPlace(int currPlace, int currScore, ArrayList<Integer> places){
        for(int i = currPlace - 1; i > 0; i--){
            int index = i - 1;
            if(currScore < places.get(index)){
                return i + 1;
            }
        }
        return 1;
    }

}

public class ClimbingLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ClimbingLeaderboardResult.climbingLeaderboard(ranked, player);

        for (int each:result) {
            System.out.println(each);
        }
        System.out.println();

        bufferedReader.close();

    }
}
