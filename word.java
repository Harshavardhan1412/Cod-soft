import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to enter text manually.");
        System.out.println("Enter '2' to provide a file path to count words from a file.");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        String text = "";
        switch (choice) {
            case 1:
                // Read text manually entered by user
                System.out.print("Enter the text to count words: ");
                text = scanner.nextLine();
                break;
            case 2:
                // Read text from file provided by user
                System.out.print("Enter the file path: ");
                String filePath = scanner.nextLine();
                try {
                    text = readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. Please check the file path.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter '1' or '2'.");
                return;
        }
        int wordCount = countWords(text);
        System.out.println("Total number of words: " + wordCount);
        scanner.close();
    }
    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder contentBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            contentBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return contentBuilder.toString();
    }
    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}+");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) { // Exclude any empty strings
                count++;
            }
        }
        return count;
    }
}
