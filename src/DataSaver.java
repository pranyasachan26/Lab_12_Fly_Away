import java.io.*;
import java.util.*;
import java.nio.file.*;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean again = true;

        while (again) {
            System.out.print("Enter First Name: ");
            String first = in.nextLine().trim();

            System.out.print("Enter Last Name: ");
            String last = in.nextLine().trim();

            int idNum = 0;
            while (true) {
                System.out.print("Enter ID Number (1–999999): ");
                try {
                    idNum = Integer.parseInt(in.nextLine().trim());
                    if (idNum >= 1 && idNum <= 999999) break;
                } catch (Exception e) {}
                System.out.println("Invalid ID. Try again.");
            }
            String idFormatted = String.format("%06d", idNum);

            System.out.print("Enter Email: ");
            String email = in.nextLine().trim();

            int yOB = 0;
            while (true) {
                System.out.print("Enter Year of Birth (1900–2099): ");
                try {
                    yOB = Integer.parseInt(in.nextLine().trim());
                    if (yOB >= 1900 && yOB <= 2099) break;
                } catch (Exception e) {}
                System.out.println("Invalid year. Try again.");
            }

            // Build CSV record
            String record = first + ", " + last + ", " + idFormatted + ", " + email + ", " + yOB;
            records.add(record);

            System.out.print("Add another record? (y/n): ");
            String answer = in.nextLine().trim().toLowerCase();
            again = answer.equals("y") || answer.equals("yes");
        }

        System.out.print("Enter file name to save (with .csv): ");
        String filename = in.nextLine().trim();
        Path file = Paths.get("src/" + filename);

        try {
            Files.write(file, records);
            System.out.println("File saved to src directory: " + file.toString());
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }
}
