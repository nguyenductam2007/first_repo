public class Main {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        String sampleText = "Lập trình Java rất thú vị. Java là ngôn ngữ phổ biến. Học Java, làm Java, sống cùng Java!";
        System.out.println("Văn bản gốc: " + sampleText + "\n");

        counter.analyze(sampleText);
        counter.displayResult();
    }
}