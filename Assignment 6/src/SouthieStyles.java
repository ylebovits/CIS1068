import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;

public class SouthieStyles {

    private static String vowels = "AEIOUaeiou";

    public static void main(String[] args) throws FileNotFoundException {

        String n = readFileToString("jaws.txt");
        String modifiedScript = "";

        Scanner readString = new Scanner(n);

        while (readString.hasNext()) {
            modifiedScript += " " + applyRules(readString.next());
        }

        writeStringToFile("jaws_out.txt", modifiedScript);
    }

    /*
     * reads in text from a file, and returns it as a string
     * returns null is file is not found
     */
    public static String readFileToString(String path) throws FileNotFoundException {
        String script = "";

        // check if file exists, if not, exit function
        File inFile = new File(path);

        if (!inFile.exists()) {
            return null;
        }

        // if file exists, read each line and concatenate to the script string
        Scanner fileContents = new Scanner(inFile);

        while (fileContents.hasNext()) {
            script += "\n" + fileContents.nextLine();
        }

        return script;
    }

    // writes a string to a file
    public static void writeStringToFile(String path, String contents) throws FileNotFoundException {

        File outFile = new File(path);

        PrintStream outStream = new PrintStream(outFile);

        outStream.print(contents);
    }

    // applies all the rules to modify a word
    public static String applyRules(String word) {
        word = rExceptions(word);
        word = replaceRWithH(word);
        word = addRToA(word);
        return veryToWicked(word);
    }

    // takes a word, and replaces the last letter with h if the last letter is r
    public static String replaceRWithH(String word) {

        int len = word.length();

        // if the word ends with an r and the second to last character is a vowel, replace it with an h
        // case sensitive
        if (word.endsWith("r") && vowels.contains(word.substring(len-2, len-1))) {
            return word.substring(0, len-1) + "h";

        } else if (word.endsWith("R") && vowels.contains(word.substring(len-2, len-1))) {
            return word.substring(0, len-1) + "H";

        } else {
            return word;
        }
    }

    // takes a word and adds r to it, if the word ends with a
    public static String addRToA(String word) {

        if (word.endsWith("a")) {
            return (word + "r");
        } else if (word.endsWith("A")) {
            return (word + "R");
        } else {
            return word;
        }
    }

    // replace word "very" with word "wicked", case sensitive, lowercase if input string is mixed case
    public static String veryToWicked(String word) {
        if (word.equals("very")) {
            return "wicked";

        } else if (word.equals("VERY")) {
            return "WICKED";

        } else if ((word.toLowerCase()).equals("very")) {
            return "wicked";

        } else {
            return word;
        }
    }

    // replace r with yah if word ends with ee or i
    public static String rExceptions(String word) {
        int len = word.length();

        if (word.endsWith("eer") || word.endsWith("ir")) {
            return word.substring(0, len - 1) + "yah";

        } else if (word.endsWith("EER") || word.endsWith("IR")) {
            return word.substring(0, len - 1) + "YAH";

        // in case of weird capitalization
        } else if (word.toLowerCase().endsWith("eer") || word.toLowerCase().endsWith("ir")) {
            return word.substring(0, len - 1) + "yah";
        }

        if (word.endsWith("oor")) {
            return word.substring(0, len - 1) + "wah";

        } else if (word.endsWith("OOR")) {
            return word.substring(0, len - 1) + "WAH";

        // in case of weird capitalization
        } else if (word.toLowerCase().endsWith("oor")) {
            return word.substring(0, len - 1) + "wah";
        }

        return word;
    }
}
