public class ObjectiveQuestion extends Question {
    protected String correctAnswer;

    public ObjectiveQuestion(int points, double difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }

    // just like toString, but show the correct answer below the question
    public String withAnswerToString() {
        return "(" + this.points + " pts.) " + this.questionText + "\nCorrect answer: " + this.correctAnswer + "\n";
    }

}
