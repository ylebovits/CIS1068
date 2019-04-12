import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {
    private ObjectiveQuestion[] questions;
    private int totalPoints;
    private String testName;

    // since we don't want to modify the array from within the test
    public Test(final ObjectiveQuestion[] questions) {
        this.questions = questions;

        for (Question q : questions)
            totalPoints += q.getPoints();
    }

    public String toString() {
        String testString = "";

        for (Question q: this.questions) {
            testString += q.toString();
        }

        return testString;
    }

    public String answerKey() {
        String AK = "";

        for (Question q : this.questions) {
            AK += q.withAnswerToString() + "\n";
        }

        return AK;
    }

    // print the answer key to a file
    public void keyToFile() throws FileNotFoundException {
        String path = "";
        PrintStream outFile = new PrintStream(new File(path));
        outFile.print(this.answerKey());
        outFile.close();
    }


    // print the test to a file
    public void toFile() throws FileNotFoundException {
        String path = this.testName.replace(" ", "_").toLowerCase() + "_answers.txt";
        PrintStream outFile = new PrintStream(new File(path));
        outFile.print(this);
        outFile.close();
    }
}
