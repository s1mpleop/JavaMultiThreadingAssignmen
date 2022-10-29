import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MyRunnable implements Runnable{
    private final Path path;

    public MyRunnable(Path path) {
        this.path = path;
    }

    @Override
    public void run() {
        List<String> lines;
        try {
            lines = Files.readAllLines(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       String stockName = null;
        float average = 0;
        for(int i = 1; i < lines.size(); i++) {
            String[ ] array = lines.get(i).split(",");
            average = average + Float.parseFloat(array[8]);
            stockName = array[1];
        }

       System.out.println("Average closing price for stock " + stockName +" is " + average/( lines.size()-1));
    }
    }

