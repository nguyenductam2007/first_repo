import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Java is fun. Java is powerful! Is Java everywhere? Yes, it is.";

        System.out.println("Văn bản gốc: " + text);

        String[] words = WordFormat.formating(text);

        WordAnalyzer analyzer = new WordAnalyzer();

        analyzer.countWord(words);

        List<String> mostFrequents = analyzer.mostFrequentWord();

        if (!mostFrequents.isEmpty()) {

            int maxCount = analyzer.getCount(mostFrequents.get(0));

            System.out.print("Từ xuất hiện nhiều nhất (" + maxCount + " lần) là: ");
            for (String word : mostFrequents) {
                System.out.print("'" + word + "'  ");
            }
            System.out.println();
        }

        List<String> uniqueWords = analyzer.getUniqueWords();
        System.out.println("Các từ chỉ xuất hiện 1 lần: " + uniqueWords);
    }
}