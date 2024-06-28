import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TextAnalysisTool {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // User Input
    System.out.println("Please enter a paragraph or a lengthy text: ");
    String inputText = scanner.nextLine();

    // Character Count
    int charCount = inputText.length();
    System.out.println("Total number of characters: " + charCount);

    // Word Count
    String[] words = inputText.split("\\s+");
    int wordCount = words.length;
    System.out.println("Total number of words: " + wordCount);

    // Most Common Character
    char mostCommonChar = findMostCommonChar(inputText);
    System.out.println("Most common character: " + mostCommonChar);

    // Character Frequency
    System.out.println("Enter a character to find its frequency: ");
    char charToFind = scanner.next().charAt(0);
    int charFrequency = findCharFrequency(inputText, charToFind);
    System.out.println("Frequency of '" + charToFind + "': " + charFrequency);

    // Word Frequency
    System.out.println("Enter a word to find its frequency: ");
    scanner.nextLine(); // Consume newline
    String wordToFind = scanner.nextLine();
    int wordFrequency = findWordFrequency(inputText, wordToFind);
    System.out.println("Frequency of '" + wordToFind + "': " + wordFrequency);

    // Unique Words
    int uniqueWordCount = findUniqueWords(inputText);
    System.out.println("Number of unique words: " + uniqueWordCount);

    scanner.close();
  }

  private static char findMostCommonChar(String text) {
    Map<Character, Integer> charCountMap = new HashMap<>();
    for (char c : text.toCharArray()) {
      char lowerCaseChar = Character.toLowerCase(c);
      charCountMap.put(lowerCaseChar, charCountMap.getOrDefault(lowerCaseChar, 0) + 1);
    }
    char mostCommonChar = ' ';
    int maxCount = 0;
    for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
      if (entry.getValue() > maxCount) {
        mostCommonChar = entry.getKey();
        maxCount = entry.getValue();
      }
    }
    return mostCommonChar;
  }

  private static int findCharFrequency(String text, char charToFind) {
    charToFind = Character.toLowerCase(charToFind);
    int frequency = 0;
    for (char c : text.toCharArray()) {
      if (Character.toLowerCase(c) == charToFind) {
        frequency++;
      }
    }
    return frequency;
  }

  private static int findWordFrequency(String text, String wordToFind) {
    String[] words = text.split("\\s+");
    int frequency = 0;
    for (String word : words) {
      if (word.equalsIgnoreCase(wordToFind)) {
        frequency++;
      }
    }
    return frequency;
  }

  private static int findUniqueWords(String text) {
    String[] words = text.split("\\s+");
    Set<String> uniqueWords = new HashSet<>();
    for (String word : words) {
      uniqueWords.add(word.toLowerCase());
    }
    return uniqueWords.size();
  }
}
