import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.util.List;

public class ReadFileTests {

    @Test
    public void testReadTxtFile() {
        String fileName = "/Users/ericadiaciuc/Desktop/алгоритмы и стр/lab0/Table.txt";
        List<Video_Cards> videoCards = ReadFile.readTxtFile(fileName);

        // Assert that the returned list is not null
        assertNotNull(videoCards);

        // Assert that the size of the list is as expected
        assertEquals(3, videoCards.size());

        // Assert that the first video card in the list has the expected values
        Video_Cards firstCard = videoCards.get(0);
        assertEquals(1, firstCard.getProduct_code());
        assertEquals("NVIDIA", firstCard.getName());
        assertEquals("GeForce RTX 3080", firstCard.getProducer());
        assertEquals(10, firstCard.getTechnicalProcess());
        assertEquals(1500, firstCard.getEnergyConsum());
        assertEquals(899.99, firstCard.getPrice(), 0.01);
    }

    @Test
    public void testSerialize() {
        // Create a collection of video cards to serialize
        List<Video_Cards> videoCards = List.of(
                new Video_Cards(1, "NVIDIA", "GeForce RTX 3080", 10, 1500, 899.99),
                new Video_Cards(2, "AMD", "Radeon RX 6800 XT", 16, 2100, 999.99)
        );

        // Create a temporary file path to serialize to
        Path tempFilePath = Path.of("tempfile.txt");

        // Serialize the video cards to the temporary file
        ReadFile.serialize(videoCards, tempFilePath);

        // Read the serialized video cards back in
        List<Video_Cards> deserializedCards = ReadFile.readTxtFile(tempFilePath.toString());

        // Assert that the deserialized list is not null
        assertNotNull(deserializedCards);

        // Assert that the deserialized list has the expected size
        assertEquals(2, deserializedCards.size());

        // Assert that the deserialized list contains the expected video cards
        assertTrue(deserializedCards.contains(videoCards.get(0)));
        assertTrue(deserializedCards.contains(videoCards.get(1)));

        // Delete the temporary file
        tempFilePath.toFile().delete();
    }
}
