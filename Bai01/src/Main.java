public class Main{
    public static void useString(){
        long startTime = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i<100000;i++){
            s+="Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thoi gian chay cua String: "+(endTime-startTime)+"ms");
    }
    public static void useStringBuffer(){
        long startTime = System.currentTimeMillis();
        StringBuffer s = new StringBuffer();
        for (int i = 0;i < 100000;i++){
            s.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thoi gian chay cua StringBuffer: "+(endTime-startTime)+"ms");
    }
    public static void contentAnalysis(String text){
        System.out.println("van ban goc"+text);
        int sentenceCount = 0;
        for (int i = 0;i<text.length();i++){
            char c = text.charAt(i);
            if (c == '?'|| c=='.' || c=='!'){
                sentenceCount+=1;
            }
        }
        String modifiedText = text.replace("Java","Python");
        System.out.println("so cau trong text: "+sentenceCount);
        System.out.println("van ban da duoc chinh sua: "+modifiedText);
    }



    public static void main(String[] args){
        useString();
        useStringBuffer();

    }
}