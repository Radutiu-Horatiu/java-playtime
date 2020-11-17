import java.util.List;

public class csvThread extends Thread{
    private final List<String> data;
    private final Distance d;
    private final String word;
    private double min = 10000000;
    private String matchWord;

    public csvThread(List<String> data, Distance d, String word) {
        this.data = data;
        this.d = d;
        this.word = word;
    }

    public double getMin() {
        return min;
    }

    public String getMatch() {
        return matchWord;
    }

    @Override
    public void run() {
        for (String obj:data) {
            double distance = d.compute(word,obj);
            if (distance < min) {
                min = distance;
                matchWord = obj;
            }
        }
    }
}
