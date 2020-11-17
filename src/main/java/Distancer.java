import java.util.List;

public class Distancer {

    private Distance d;
    private CSVReader r;

    public Distancer(Distance d, CSVReader r) {
        this.d = d;
        this.r = r;
    }

    public String findWord(String word) {
        double valMin = word.length();
        String matchLine = "";
        String matchWord = "";
        for (String line:CSVReader.read(0)) {
            String[] splittedLine = line.split(" ");
            for (String obj:splittedLine) {
                double val = d.compute(obj, word);
                if (val < valMin){
                    valMin = val;
                    matchLine = line;
                    matchWord = obj;
                }
            }
        }
        return matchWord + '-' + matchLine;
    }
}
