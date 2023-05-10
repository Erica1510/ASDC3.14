import org.junit.Test;
import static org.junit.Assert.*;

public class Video_CardTests {

    @Test
    public void testGettersAndSetters() {
        Video_Cards videoCard = new Video_Cards(1, "GeForce RTX 3080", "NVIDIA", 8, 320, 699.99);

        assertEquals(1, videoCard.getProduct_code());
        assertEquals("GeForce RTX 3080", videoCard.getName());
        assertEquals("NVIDIA", videoCard.getProducer());
        assertEquals(8, videoCard.getTechnicalProcess());
        assertEquals(320, videoCard.getEnergyConsum());
        assertEquals(699.99, videoCard.getPrice(), 0.001);

        videoCard.setProduct_code(2);
        videoCard.setName("GeForce RTX 3090");
        videoCard.setProducer("NVIDIA Corporation");
        videoCard.setTechnicalProcess(7);
        videoCard.setEnergyConsum(350);
        videoCard.setPrice(1499.99f);

        assertEquals(2, videoCard.getProduct_code());
        assertEquals("GeForce RTX 3090", videoCard.getName());
        assertEquals("NVIDIA Corporation", videoCard.getProducer());
        assertEquals(7, videoCard.getTechnicalProcess());
        assertEquals(350, videoCard.getEnergyConsum());
        assertEquals(1499.99, videoCard.getPrice(), 0.001);
    }

    @Test
    public void testEqualsAndHashCode() {
        Video_Cards videoCard1 = new Video_Cards(1, "GeForce RTX 3080", "NVIDIA", 8, 320, 699.99);
        Video_Cards videoCard2 = new Video_Cards(1, "GeForce RTX 3080", "NVIDIA", 8, 320, 699.99);
        Video_Cards videoCard3 = new Video_Cards(2, "GeForce RTX 3090", "NVIDIA Corporation", 7, 350, 1499.99);

        assertEquals(videoCard1, videoCard2);
        assertNotEquals(videoCard1, videoCard3);

        assertEquals(videoCard1.hashCode(), videoCard2.hashCode());
        assertNotEquals(videoCard1.hashCode(), videoCard3.hashCode());
    }

    @Test
    public void testClone() {
        Video_Cards videoCard1 = new Video_Cards(1, "GeForce RTX 3080", "NVIDIA", 8, 320, 699.99);
        Video_Cards videoCard2 = videoCard1.clone();

        assertEquals(videoCard1, videoCard2);
        assertNotSame(videoCard1, videoCard2);
    }

    @Test
    public void testReadAndWrite() {
        Video_Cards videoCard1 = new Video_Cards(1, "GeForce RTX 3080", "NVIDIA", 8, 320, 699.99);

        StringBuilder sb = new StringBuilder();
        try {
            videoCard1.write(sb);
        } catch (Exception e) {
            fail("Exception thrown: " + e);
        }

        String expectedOutput = "1 GeForce RTX 3080 NVIDIA 8 320 699,99";
        assertEquals(expectedOutput, sb.toString());
    }
}