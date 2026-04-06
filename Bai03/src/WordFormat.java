public class WordFormat {
    public static String[] formating(String text){
        if (text == null || text.trim().isEmpty()){
            return new String[0];
        }
        String formattedText = text.toLowerCase().replaceAll("[^a-z\\s]","");
        return formattedText.split("\\s+");
    }
}