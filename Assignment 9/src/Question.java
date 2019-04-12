public class Question {
    protected final double MIN_DIFFICULTY = 0;
    protected final double MAX_DIFFICULTY = 1.0;

    protected int points;
    protected double difficulty;
    protected int answerSpace; // lines of space
    protected String questionText;

    public Question(int points, double difficulty, int answerSpace, String questionText) {

        // in case we're given an invalid level of difficulty
        if (difficulty < MIN_DIFFICULTY)
            this.difficulty = 0.0;
        else if (difficulty > MAX_DIFFICULTY)
            this.difficulty = 1.0;
        else
            this.difficulty = difficulty;


        this.points = points;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }

    // return question as a String
    public String toString() {
        String blankLines = "\n"; // to hold \n chars to represent empty space for answer to be written
        for (int i = 0; i < this.answerSpace; ++i)
            blankLines += "\n";

        return "(" + this.points + " pts.) " + this.questionText + blankLines + "\n";
    }

    public String withAnswerToString() {

        return "(" + this.points + " pts.) Answers may vary.\n";
    }

    public int getPoints() {
        return this.points;
    }

}
