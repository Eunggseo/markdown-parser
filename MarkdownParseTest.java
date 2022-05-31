import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks() throws IOException{
         Path fileName = Path.of("test-file.md");
         String content = Files.readString(fileName);
         ArrayList<String> links = MarkdownParse.getLinks(content);
         assertEquals(List.of("https://something.com", "some-thing.html"),links);
     }
    @Test
    public void testSnippet1() throws IOException{
         Path fileName = Path.of("Snippet1.md");
         String content = Files.readString(fileName);
         ArrayList<String> links = MarkdownParse.getLinks(content);
         assertEquals(List.of("url.com", "google.com", "ucsd.edu"),links);
    }
    @Test
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("b.com", "a.com(())", "example.com"),links);
     }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(" https://www.twitter.com",
                             "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
                             "(https://cse.ucsd.edu/"), links);
     }
}