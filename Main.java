import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\Articles\\RookieQB.txt"; // Path to article
        String stopWordsPath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\stopwords.txt";    // Path to stopwords

        String positiveWordsPath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\positive-words.txt";
        String negativeWordsPath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\negative-words.txt";

        List<String> stopWords = FileHandler.readStopWords(stopWordsPath);
        List<String> positiveWords = FileHandler.readPositiveWords(positiveWordsPath);
        List<String> negativeWords = FileHandler.readNegativeWords(negativeWordsPath);

        TextProcessor textProcessor = new TextProcessor(stopWords, positiveWords, negativeWords);

        // Create instances of the handler and stopWords classes
        FileHandler fileHandler = new FileHandler();

        // fl

        // FileAnalyzer to read the text
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        // Print the filtered article
        System.out.println("Filtered Article A:");
        System.out.println("===================================");
        List<String> articleLines = fileHandler.readFile(filePath);
        List<String> cleanedLines = textProcessor.removeStopWords(articleLines);
        for (String line : cleanedLines) {
            System.out.println(line);
        }

        //Showing statistics for Article A
        int wordCount = fileAnalyzer.countWords(articleLines);
        System.out.println("Word Count: " + wordCount);

        int statementCount = fileAnalyzer.countStatements(articleLines);
        System.out.println("Number of Statements: " + statementCount);

        System.out.println("Word Frequencies: ");
        fileAnalyzer.rankWordsByFrequency(cleanedLines);

        //Print number of unique words
        System.out.println("Number of unique words: ");
        int UniqueWordsA = fileAnalyzer.countUniqueWords(articleLines);
        System.out.println(UniqueWordsA);

        List<String> words = new ArrayList<>();
        for (String line : cleanedLines) {
            for (String word : line.split("\\s+")) {
                words.add(word.toLowerCase());
            }
        }
        //Method Sentiment Analysis
        textProcessor.analyzeSentiment(words);

        int richestVocabulary = UniqueWordsA;
        String richestArticle = "A";



        // Print the second filtered article
        filePath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\Articles\\Gus Bradley_ Colts must take 'shared responsibility' to fix atrocious run defense.txt";

        System.out.println("Filtered Article B:");
        System.out.println("===================================");
        List<String> articleLinesB = fileHandler.readFile(filePath);
        List<String> cleanedLinesB = textProcessor.removeStopWords(articleLinesB);
        for (String line : cleanedLinesB) {
            System.out.println(line);
        }
        // Show statistics for Article B
        wordCount = fileAnalyzer.countWords(articleLinesB);
        System.out.println("Word Count: " + wordCount);

        statementCount = fileAnalyzer.countStatements(articleLinesB);
        System.out.println("Number of Statements: " + statementCount);

        System.out.println("Word Frequencies: ");
        fileAnalyzer.rankWordsByFrequency(cleanedLinesB);

        System.out.println("Number of unique words: ");
        int UniqueWordsB = fileAnalyzer.countUniqueWords(articleLinesB);
        System.out.println(UniqueWordsB);

        words = new ArrayList<>();
        for (String line : cleanedLinesB) {
            for (String word : line.split("\\s+")) {
                words.add(word.toLowerCase());
            }
        }
        //Method Sentiment Analysis
        textProcessor.analyzeSentiment(words);


        if (UniqueWordsB > richestVocabulary) {
            richestVocabulary = UniqueWordsB;
            richestArticle = "B";
        }


        // Print the third filtered article
        filePath = "C:\\Users\\lukas\\IdeaProjects\\PGWorkshopLab\\src\\Articles\\Aaron Rodgers on Patriots_ A 'little weird' to face coaches you've played against.txt";

        System.out.println("Filtered Article C:");
        System.out.println("==================================");
        List<String> articleLinesC = fileHandler.readFile(filePath);
        List<String> cleanedLinesC = textProcessor.removeStopWords(articleLinesC);
        for (String line: cleanedLinesC) {
            System.out.println(line);
        }
        // Show statistics for Article C
        wordCount = fileAnalyzer.countWords(articleLinesC);
        System.out.println("Word Count: " + wordCount);

        statementCount = fileAnalyzer.countStatements(articleLinesC);
        System.out.println("Number of Statements: " + statementCount);

        System.out.println("Word Frequencies: ");
        fileAnalyzer.rankWordsByFrequency(cleanedLinesC);

        System.out.println("Number of unique words: ");
        int UniqueWordsC = fileAnalyzer.countUniqueWords(articleLinesC);
        System.out.println(UniqueWordsC);

        words = new ArrayList<>();
        for (String line : cleanedLinesC) {
            for (String word : line.split("\\s+")) {
                words.add(word.toLowerCase());
            }
        }
        //Method Sentiment Analysis
        textProcessor.analyzeSentiment(words);

        if (UniqueWordsC > richestVocabulary) {
            richestVocabulary = UniqueWordsC;
            richestArticle = "C";
        }

        System.out.println("The article with the richest vocabulary: " + richestArticle);
        System.out.println("Number of unique words that it had: " + richestVocabulary);

    }
}
