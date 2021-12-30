import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileAnalyzer {

    public static void main(String[] args) throws IOException {

        File path = new File("text.txt");
        String word = "language";
        FileOutputStream fileOutputStream = new FileOutputStream(path);

    }

    //    Write Text
    public static void writeText(String text, String path) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(text.getBytes());
//        fileOutputStream.close();

    }
    //    Read Text
    public static String readText(String path) throws IOException {
        File pathToFile = new File(path);
        FileInputStream fileInputStream= new FileInputStream(path);
        int fileLength = (int) pathToFile.length();
        byte[] text = new byte[fileLength];
        fileInputStream.read(text);
        return new String(text);
    }

    public static int countInFile(String path, String word) throws IOException {
        String text = readText(path);
        int count = countInFile(text, word);
        return count;
    }

    //    search word
    public static String searchWord(String path, String searchWord) throws IOException {
        int counr = 0;
        String text = readText(path);
        String [] words = text.toLowerCase().replaceAll("[.?!]", " ---- ").split("\\s");
        for(String word: words){
            if(word.equals(searchWord)){
                counr++;
            }
        }
        String result = "The word: " + searchWord + "Tomes in the file: " + counr;
        System.out.println(result);
        return result;
    }

    //  search "!?."
    public static String[] searchMarks(String text, String searched) throws IOException {
        int arrayLength = countInFile(text, searched);
        int index = 0;
        String[] sentence = text.split("[!?.\n]");
        String[] marks =  new String[arrayLength];
        for (String sentences :sentence ){
            if(countInFile(sentences, searched) > 0){
                marks[index] = sentences;
                index ++;
            }
        }
        return marks;
    }

    public static void printText(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
}