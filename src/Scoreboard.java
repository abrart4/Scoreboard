public class Scoreboard {
    private String teamOne;
    private String teamTwo;
    private String activeTeam;
    private int teamOneScore;
    private int teamTwoScore;

    /**
     The constructor has two parameters. The first parameter is a String containing the
     name of team 1, and the second parameter is a String containing the name of team 2.
     The game always begins with team 1 as the active team.
     */
    public Scoreboard(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        activeTeam = teamOne;
    }

    /**
     * The recordPlay method has a single nonnegative integer parameter that is equal to the
     * number of points scored on a play or 0 if the play failed. If the play results in one or
     * more points scored, the active team’s score is updated and that team remains active. If the
     * value of the parameter is 0, the active team’s turn ends and the inactive team becomes the
     * active team. The recordPlay method does not return a value.
     */
    public void recordPlay(int points) {
        if (points >= 1) {
            if (activeTeam.equals(teamOne)) {
                teamOneScore += points;
            }
            else {
                teamTwoScore += points;
            }
        }
        else {
            if (activeTeam.equals(teamOne)) {
                activeTeam = teamTwo;
            }
            else {
                activeTeam = teamOne;
            }
        }
    }

    /**
     * The getScore method has no parameters. The method returns a String containing
     * information about the current state of the game. The returned string begins with the score of
     * team 1, followed by a hyphen ("-"), followed by the score of team 2, followed by a
     * hyphen, followed by the name of the team that is currently active.
     */
    public String getScore() {
        return teamOneScore + "-" + teamTwoScore + "-" + activeTeam;
    }
}
