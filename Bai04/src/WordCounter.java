import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap;

    public WordCounter() {
        this.wordMap = new HashMap<>();
    }

    public void analyze(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }
        String normalisedText = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        String[] words = normalisedText.split("\\s+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (wordMap.containsKey(word)) {
                int currentCount = wordMap.get(word);
                wordMap.put(word, currentCount + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
    }

    public void displayResult() {
        if (wordMap.isEmpty()) {
            System.out.println("Không có dữ liệu để hiển thị.");
        } else {
            int maxCount = 0;
            List<String> mvp = new ArrayList<>();

            System.out.println("--- DANH SÁCH TỪ VÀ SỐ LƯỢNG ---");
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                String currentWord = entry.getKey();
                int currentCount = entry.getValue();

                System.out.println("- " + currentWord + ": " + currentCount);

                // Logic tìm các từ xuất hiện nhiều nhất của bạn
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mvp.clear();
                    mvp.add(currentWord);
                } else if (currentCount == maxCount) {
                    mvp.add(currentWord);
                }
            }

            System.out.println("\n--- TỔNG KẾT ---");
            System.out.println("Các từ xuất hiện nhiều nhất: " + String.join(", ", mvp));
            System.out.println("Số lần xuất hiện nhiều nhất: " + maxCount + " lần.");

        }
    }
}
