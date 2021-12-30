import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {

    File path = new File("text.txt");
    String word = "language";
    FileAnalyzer analyzer = new FileAnalyzer();
//    String text = "A programming language is a formal language comprising a set of strings that produce various kinds of machine code output. Programming languages are one kind of computer language and are used in computer programming to implement algorithms! ";


    @Test
    public void countNumberOfLetter() throws IOException{
        String text = "A programming language is a formal language comprising a set of strings that produce various kinds of machine code output. Programming languages are one kind of computer language and are used in computer programming to implement algorithms! ";
        String actual = FileAnalyzer.searchWord(text, "a");
        assertEquals(0, actual);
    }

    @Test
    public void testVerifyWordMeetsCoupleTimes() throws IOException {
        File.createTempFile("text", "txt", new File("D:\\JavaC\\file"));

        String text = "A programming language is a formal language comprising a set of strings that produce various kinds of machine code output. Programming languages are one kind of computer language and are used in computer programming to implement algorithms! ";

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaC\\file\\text.txt");
        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();

        assertEquals(2, Integer.parseInt(String.valueOf(FileAnalyzer.countInFile("D:\\JavaC\\file\\text.txt", "language"))));
    }

    @Test
    public void countNumberOfWord() throws IOException{
        String text = "A programming language is a formal language comprising a set of strings that produce various kinds of machine code output. Programming languages are one kind of computer language and are used in computer programming to implement algorithms! ";
        String actual = FileAnalyzer.searchWord(text, "language");
        assertEquals(0, actual);
    }

    @Test
    public void testVerifyWordMeetsJustOnce() throws IOException {
        File.createTempFile("text", "txt", new File("D:\\JavaC\\file"));

        String text = "A programming language is a formal language comprising a set of strings that produce various kinds of machine code output. Programming languages are one kind of computer language and are used in computer programming to implement algorithms! ";

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaC\\file\\text.txt");
        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();

        assertEquals(1, Integer.parseInt(String.valueOf(FileAnalyzer.countInFile("D:\\JavaC\\file\\text.txt", "language"))));
    }



}


