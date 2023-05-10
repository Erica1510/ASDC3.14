
// импортируем необходимые классы
// без них компилятор выдаст ошибку
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// класс ReadFile находится в файле ReadFile
class ReadFile
{
    // статический метод для чтения файла
    public static List<Video_Cards> readTxtFile(String fileName) {

        try(Stream<String> lines = Files.lines(Path.of(fileName));) {
            return lines.map(line -> {
                        String[] words = line.split(" ");
                        return new Video_Cards(
                                Integer.parseInt(words[0]),
                                words[1],
                                words[2],
                                Integer.parseInt(words[3]),
                                Integer.parseInt(words[4]),
                                Double.parseDouble(words[5])
                        );
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void serialize(Collection<Video_Cards> videoCards, Path filePath) {
        try {
            Collection<? extends CharSequence> transactionsToSerialize = videoCards
                    .stream()
                    .map(Video_Cards::toString)
                    .collect(Collectors.toCollection(ArrayList::new));
            Files.write(filePath, transactionsToSerialize, Charset.defaultCharset());
        }
        catch (IOException e) {
            System.err.println("Something went wrong when serializing videocards");
        }
    }
}