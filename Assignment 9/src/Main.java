import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion(5, 0.25, 1, "Who's the prof?", "Fiore", new String[] {"Hughes", "Fiore", "Wang", "Rosen"});
        ObjectiveQuestion q2 = new ObjectiveQuestion(10, 0.125, 1, "What is a preprocessor directive?", "something in C");
        FillInTheBlankQuestion q3 = new FillInTheBlankQuestion(5, 0.1, 1, "is the school we go to.", "TU");

        ObjectiveQuestion[] qs = {q1, q2, q3};

        Test t = new Test(qs);

        System.out.println("Test:");
        System.out.println(t);

        System.out.println("Answer Key:");
        System.out.println(t.answerKey());

        t.toFile();
        t.keyToFile();



    }
}
