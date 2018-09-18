import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    public static void main(String[] args) {
        String text = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String word = "and";

        System.out.println(text);
        System.out.println("----------------------------\nWord Count: " + countWords(text));
        System.out.println("----------------------------\nNumber of times \'" + word +"\' is used: " + countInstanceOfWord(word, text));
    }


    /**
     * Calculates and returns the word count of a given String
     *
     * @param text the String text being analyzed
     * @return the word count of text
     */
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] allWords = text.split("\\s+");

        return allWords.length;
    }

    /**
     * Counts and returns the number of times a word is used in a given text
     *
     * @param word the String that we are looking for and counting the instances of
     * @return the number of times word appears in text
     */
    public static int countInstanceOfWord(String word, String text) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        String[] allWords = text.split("\\s+");

        int countOfWord = 0;

        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].toLowerCase().equals(word.toLowerCase())) {
                countOfWord++;
            }
        }

        return countOfWord;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
