import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAnalyzer {
    private Map<String,Integer> wordcounter;

    public WordAnalyzer(){
        this.wordcounter = new HashMap<>();
    }

    public void countWord(String[] s){
        for (String word : s){
            if (word.isEmpty()) continue;
            if (wordcounter.containsKey(word)){
                int solanCu = wordcounter.get(word);
                int solanMoi = solanCu + 1;
                wordcounter.put(word, solanMoi);
            } else {
                wordcounter.put(word, 1);
            }
        }
    }

    public List<String> mostFrequentWord(){
        int maxFreq = 0;
        List<String> famous = new ArrayList<>();
        for (Map.Entry<String,Integer> entry: wordcounter.entrySet()){
            int currentFreq = entry.getValue();
            String currentWord = entry.getKey();
            if (currentFreq > maxFreq){
                maxFreq = currentFreq;
                famous.clear();
                famous.add(currentWord);
            }
            else if (currentFreq == maxFreq){
                famous.add(currentWord);
            }
        }
        return famous;
    }

    public List<String> getUniqueWords(){
        List<String> uniqueWord = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : wordcounter.entrySet()){
            if (entry.getValue() == 1){
                uniqueWord.add(entry.getKey());
            }
        }
        return uniqueWord;
    }

    // ĐÃ THÊM HÀM NÀY ĐỂ MAIN CÓ THỂ LẤY ĐƯỢC SỐ LƯỢNG
    public int getCount(String word) {
        return wordcounter.getOrDefault(word, 0);
    }
}