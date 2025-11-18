import java.io.File;
import java.io.FileNotFoundException;
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

        String teamOne = scoreboardScanner.next();
        String teamTwo = scoreboardScanner.next();
        Scoreboard scoreboard = new Scoreboard(teamOne, teamTwo);
        while (scoreboardScanner.hasNextInt()) {
            int points = scoreboardScanner.nextInt();
            scoreboard.recordPlay(points);
        }
    }
}
