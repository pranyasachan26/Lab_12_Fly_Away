import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src"));

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File chosenFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try {
                Scanner in = new Scanner(chosenFile);

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);

                    lineCount++;

                    if (!line.trim().isEmpty()) {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }

                    charCount += line.length();
                }

                in.close();

                System.out.println("\n=== SUMMARY REPORT ===");
                System.out.println("File Name: " + chosenFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        }
    }
}
