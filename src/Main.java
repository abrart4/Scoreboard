import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String info;
        Scoreboard game = new Scoreboard("Red", "Blue");
        info = game.getScore();
        System.out.println(info);
        game.recordPlay(1);
        info = game.getScore();
        System.out.println(info);
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        info = game.getScore();
        System.out.println(info);
        game.recordPlay(3);
        info = game.getScore();
        System.out.println(info);
        game.recordPlay(1);
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info);
        Scoreboard match =
                new Scoreboard("Lions", "Tigers");
        info = match.getScore();
        System.out.println(info);
        info = game.getScore();
        System.out.println(info);

        read();
    }

    public static void read() throws FileNotFoundException {
        File scoreboardFile = new File("Scoreboard.txt");
        Scanner scoreboardScanner = new Scanner(scoreboardFile);

        HashMap<String, Integer> teamStats = new HashMap<>();

        while (scoreboardScanner.hasNextLine()) {
            String teamOne = scoreboardScanner.next();
            String teamTwo = scoreboardScanner.next();
            Scoreboard scoreboard = new Scoreboard(teamOne, teamTwo);
            while (scoreboardScanner.hasNextInt()) {
                int points = scoreboardScanner.nextInt();
                scoreboard.recordPlay(points);
            }
            String result = scoreboard.getScore();
            String[] separated = result.split("-");
            String teamOneScoreString = separated[0];
            String teamTwoScoreString = separated[1];
            int teamOneScore = Integer.parseInt(teamOneScoreString);
            int teamTwoScore = Integer.parseInt(teamTwoScoreString);
            if (teamOneScore > teamTwoScore) {
                if (teamStats.containsKey(teamOne)) {
                    teamStats.put(teamOne, teamStats.get(teamOne) + 1);
                }
                else {
                    teamStats.put(teamOne, 1);
                }
            }
            else if (teamTwoScore > teamOneScore) {
                if (teamStats.containsKey(teamTwo)) {
                    teamStats.put(teamTwo, teamStats.get(teamTwo) + 1);
                }
                else {
                    teamStats.put(teamTwo, 1);
                }
            }
        }
        // {Red=141, Violet=148, Yellow=122, Blue=132, Indigo=151, Orange=165, Green=140}
        System.out.println(teamStats);
        // Which team wins the most games? -> Orange
        // How many games does that team win? -> 165
        // Which team wins the fewest games? -> Yellow
        // How many games does that team win? -> 122
    }
}
