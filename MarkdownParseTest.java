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
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com", "some-thing.html"), 
                            MarkdownParse.getLinks(content));
    }

    @Test
    public void testGetLinks2() throws IOException{
        Path fileName = Path.of("mytest-file.md");
        // Path fileName = Path.of("mytest-file.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("https://something.com", "some-thing.html",
                    "www.google.com"), 
        MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet1() throws IOException{
        // Path fileName = Path.of("/Users/hantian_lin/Documents/GitHub/markdown-parser/snippet1.md");
        Path fileName = Path.of("/Users/wenyuzhong/Documents/GitHub/markdown-parsergroup2/Snippet 1.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
        MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet2() throws IOException{
        //Path fileName = Path.of("/Users/hantian_lin/Documents/GitHub/markdown-parser/snippet2.md");
        Path fileName = Path.of("/Users/wenyuzhong/Documents/GitHub/markdown-parsergroup2/snippet 2.md");
        String content = Files.readString(fileName);

        assertEquals(List.of("a.com", "a.com(())", "example.com"), 
        MarkdownParse.getLinks(content));
    }

    @Test
    public void testSnippet3() throws IOException{
        //Path fileName = Path.of("/Users/hantian_lin/Documents/GitHub/markdown-parser/snippet3.md");
        Path fileName = Path.of("/Users/wenyuzhong/Documents/GitHub/markdown-parsergroup2/Snippet 3.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://www.twitter.com",
                            "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
                            "https://cse.ucsd.edu/"),
        MarkdownParse.getLinks(content));
    }
}