import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    //private MarkdownParse links = new MarkdownParse();

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException{
        // Path fileName = Path.of("/Users/hantian_lin/Documents/GitHub/markdown-parser/test-file.md");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com", "some-thing.html"), 
                            MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinks2() throws IOException{
        // Path fileName = Path.of("/Users/hantian_lin/Documents/GitHub/markdown-parser/mytest-file.md");
        Path fileName = Path.of("mytest-file.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("https://something.com", "some-thing.html",
                    "www.google.com"), 
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet1GetLinks() throws IOException{
        Path fileName = Path.of("Snippet1.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("url.com", "google.com",  "ucsd.edu"), 
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet2GetLinks() throws IOException{
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("b.com", "a.com(())",  "example.com"), 
        MarkdownParse.getLinks(content));
    }
    @Test
    public void snippet3GetLinks() throws IOException{
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);

        assertEquals(List.of(" https://www.twitter.com",
                             "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
                             "(https://cse.ucsd.edu/"), 
        MarkdownParse.getLinks(content));
    }
}
