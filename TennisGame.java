public class TennisGame {

    public static final String SCORE = "";
    public static final int TEMP_SCORE = 0;
    

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = SCORE;
        int tempScore= TEMP_SCORE;
        if (player1Score==player2Score)
        {
            score= getEqualScore(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            score = getAdvantageOrWinScore(player1Score, player2Score);
        }
        else
        {
            score = getNormalScore(player1Score, player2Score, score);
        }
        return score;
    }

    private static String getNormalScore(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1)
            {
                tempScore = player1Score;
            }
            else
            {
                score +="-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0 -> score += "Love";
                case 1 -> score += "Fifteen";
                case 2 -> score += "Thirty";
                case 3 -> score += "Forty";
            }
        }
        return score;
    }

    private static String getAdvantageOrWinScore(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String getEqualScore(int player1Score) {
        String score;
        score = switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
        return score;
    }
}
