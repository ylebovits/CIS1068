import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class TestBank {

    private ObjectiveQuestion[] questionBank;
    private Random rand;

    public TestBank(ObjectiveQuestion[] questionBank) {
        this.questionBank = questionBank;
        this.rand = new Random();
    }

    /* create an array and fill it with randomly chosen questions from the bank */
    public Test generateTest(int size) {
        ObjectiveQuestion[] test = new ObjectiveQuestion[size];

        for (int i = 0; i < size; ++i)
            test[i] = questionBank[randInt(0, size)];

        return new Test(test);
    }

    private int randInt(int min, int max) {
        return this.rand.nextInt(max - min + 1) + min;
    }

    public boolean writeQuestionstoFile(String path, Test test) {
        try {

            PrintStream testOut = new PrintStream(new File(path));
            testOut.print(test);
            return true;

        } catch (FileNotFoundException err) {
            return false;
        }
    }
}
