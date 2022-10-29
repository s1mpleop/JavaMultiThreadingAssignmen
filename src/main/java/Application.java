import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        ArrayList<Path> collect;
        try (Stream<Path> paths = Files.walk(Paths.get("src", "main","resources","JavaAssignment1"))) {
            collect = paths.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        collect.remove(0);
        ArrayList<Thread> threads = new ArrayList<>();
        collect.forEach(
                collect1 -> {
                    MyRunnable myRunnable = new MyRunnable(collect1);
                    threads.add(
                            new Thread(myRunnable)
                    );
                }
        );
        threads.forEach(
                thread -> {
                    thread.start();
                }
        );
    }

}
