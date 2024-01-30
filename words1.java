import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class words1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the text file:");
        String filePath = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            Set<String> uniqueWords = new HashSet<>();
            Map<String, Integer> wordFrequency = new HashMap<>();
            List<String> sentences = new ArrayList<>();

            int charCount = 0;
            int repeatedWordCount = 0;
            int sentenceCount = 0;
            String sentenceSplit = "[.!?]+";
            int lineCount = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                lineCount++;

                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();
                    uniqueWords.add(word);
                    int wordCount = wordFrequency.getOrDefault(word, 0) + 1;
                    wordFrequency.put(word, wordCount);
                    if (wordCount > 1) {
                        repeatedWordCount += wordCount - 1;
                    }
                    charCount += word.length();
                }
                String[] lineSentences = line.split(sentenceSplit);
                sentenceCount += lineSentences.length;
                sentences.addAll(Arrays.asList(lineSentences));
            }

            
            sentences.removeIf(String::isEmpty);
            sentenceCount = sentences.size();

            int uniqueWordCount = uniqueWords.size();

            repeatedWordCount = wordFrequency.values().stream().filter(count -> count > 1).mapToInt(count -> count - 1).sum();
            int totalWordCount = uniqueWords.size() + repeatedWordCount;
            System.out.println("\nTotal Word count: \u001B[33m" + totalWordCount + "\u001B[0m");
            System.out.println("Unique word count: \u001B[33m" + uniqueWordCount + "\u001B[0m");
            System.out.println("Repeated word count: \u001B[33m" + repeatedWordCount + "\u001B[0m");
            System.out.println("Sentence count: \u001B[33m" + sentenceCount + "\u001B[0m");
            System.out.println("Line count: \u001B[33m" + lineCount + "\u001B[0m");
            System.out.println("Character count: \u001B[33m" + charCount + "\u001B[0m\n");

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please provide a valid Filename");
            e.printStackTrace();
        }
    }
}
