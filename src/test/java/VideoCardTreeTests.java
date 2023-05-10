import org.junit.Test;

import static org.junit.Assert.*;

public class VideoCardTreeTests {

    @Test
    public void testAddVideoCards() {
        Video_Cards card1 = new Video_Cards(1, "GTX 1050", "Nvidia", 4, 320, 699.99);
        Video_Cards card2 = new Video_Cards(2, "RX 580", "AMD", 8, 320, 699.99);

        VideoCardTree tree = new VideoCardTree();
        tree.addVideoCards(card1);
        tree.addVideoCards(card2);

        assertEquals(tree.findVideoCardByCode(1), card1);
        assertEquals(tree.findVideoCardByCode(2), card2);
    }

    @Test
    public void testFindVideoCardByCode() {
        Video_Cards card1 = new Video_Cards(1, "GTX 1050", "Nvidia", 4, 320, 699.99);
        Video_Cards card2 = new Video_Cards(2, "RX 580", "AMD", 8, 320, 699.99);

        VideoCardTree tree = new VideoCardTree(card1, card2);

        assertEquals(tree.findVideoCardByCode(1), card1);
        assertEquals(tree.findVideoCardByCode(2), card2);
    }

    @Test(expected = IllegalStateException.class)
    public void testFindVideoCardByCodeThrowsException() {
        VideoCardTree tree = new VideoCardTree();
        tree.findVideoCardByCode(1);
    }

    @Test
    public void testRemoveVideoCard() {
        Video_Cards card1 = new Video_Cards(1, "GTX 1050", "Nvidia", 4, 320, 699.99);
        Video_Cards card2 = new Video_Cards(2, "RX 580", "AMD", 8, 320, 699.99);

        VideoCardTree tree = new VideoCardTree(card1, card2);
        tree.removeVideoCard(1);

        assertNull(tree.findVideoCardByCode(1));
        assertEquals(tree.findVideoCardByCode(2), card2);
    }
}
