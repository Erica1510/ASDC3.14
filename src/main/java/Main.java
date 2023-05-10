import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static List<Video_Cards> videoCardsList;
    public static void main(String[] args) throws IOException {
        videoCardsList = ReadFile.readTxtFile("/Users/ericadiaciuc/Desktop/алгоритмы и стр/lab0/Table.txt");
        Video_Cards[] videoCards = videoCardsList.toArray(new Video_Cards[0]);

        VideoCardTree videoCardTree = new VideoCardTree(videoCards);
        videoCardTree.preorder();
        System.out.println();
        videoCardTree.inorder();
        System.out.println();
        videoCardTree.postorder();
        System.out.println();



    }
}