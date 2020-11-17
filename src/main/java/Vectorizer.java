import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface Vectorizer {
    public List<Double> transform(List<String> list);
    public void buildVocabulary(List<String> list);
}
