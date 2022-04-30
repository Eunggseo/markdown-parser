import static org.junit.Assert.*;

<<<<<<< HEAD
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
=======
import java.beans.Transient;
import java.nio.file.Files;
>>>>>>> 263914c6530ff9142fefa60fc101b509828a5e12
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    @Test
<<<<<<< HEAD
    public void addition(){
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
}
=======
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

}
>>>>>>> 263914c6530ff9142fefa60fc101b509828a5e12
