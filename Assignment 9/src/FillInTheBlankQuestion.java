public class FillInTheBlankQuestion extends ObjectiveQuestion {

    private int correctAnswerSpace;

    public FillInTheBlankQuestion(int points, double difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText, correctAnswer);
        correctAnswerSpace = correctAnswer.length();
    }


    @Override
    public String toString() {
        String emptySpaces = "__";
        for (int i = 0; i < this.correctAnswerSpace; ++i)
            emptySpaces += "_";

        return "(" + this.points + " pts.) " + emptySpaces + " " + this.questionText + "\n";
    }

    @Override
    // just like toString, but show the correct answer rather than a blank space
    public String withAnswerToString() {
        return "(" + this.points + " pts.) _" + this.correctAnswer + "_ " + this.questionText + "\n";
    }

}
