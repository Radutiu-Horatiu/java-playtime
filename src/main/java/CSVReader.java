import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<String> read(int col) {
        String csvFile = "train-all.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\",[,0-1],\"";
        List<String> arr = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] obj = line.split(cvsSplitBy);
                if (obj.length > 1)
                    arr.add(obj[col]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return arr;
    }
}
