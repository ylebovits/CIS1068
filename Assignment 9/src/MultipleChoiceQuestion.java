public class MultipleChoiceQuestion extends ObjectiveQuestion {

    private String[] possibleAnswers;

    public MultipleChoiceQuestion(int points, double difficulty, int answerSpace, String questionText, String correctAnswer, String[] possibleAnswers) {
        super(points, difficulty, answerSpace, questionText, correctAnswer);
        this.possibleAnswers = possibleAnswers;
    }

    @Override
    public String toString() {
        String questions = "\n";

        for (int i = 0; i < this.possibleAnswers.length; i++)
            questions += (i+1) + ". " + this.possibleAnswers[i] + "\n";

        return "(" + this.points + " pts.) " + this.questionText + questions;
    }

    @Override
    // just like toString, but highlight the correct answer
    public String withAnswerToString() {
        String questions = "\n";

        for (int i = 0; i < this.possibleAnswers.length; i++) {
            if (this.possibleAnswers[i].equalsIgnoreCase(this.correctAnswer))
                questions += (i + 1) + ". --> " + this.possibleAnswers[i] + " <--\n";
            else
                questions += (i + 1) + ". " + this.possibleAnswers[i] + " \n";

        }

        return "(" + this.points + " pts.) " + this.questionText + questions + "\n";
    }
}
