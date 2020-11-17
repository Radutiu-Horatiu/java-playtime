import java.util.*;

public class BagOfWords implements Vectorizer {

    public List<String> vocabulary;

    @Override
    public void buildVocabulary(List<String> list) {

        List<String> listWithoutDuplicates = new ArrayList<>(
                new HashSet<>(list));

        vocabulary = listWithoutDuplicates;
    }

    private double countWords(String word, List<String> list){
        double ct=0;
        for (String w:list) {
            if(w.equals(word))
                ct++;
        }
        return ct;
    }

    public static List<String> spliter(String prop){
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(prop.split(" ")));

        return words;
    }

    @Override
    public List<Double> transform(List<String> list) {
        List<Double> counter = new ArrayList<Double>(Collections.nCopies(vocabulary.size(), (double)0));

        for (int i = 0; i < vocabulary.size(); i++) {
            if (list.contains(vocabulary.get(i))) {
                counter.set(i, counter.get(i) + 1);
            }
        }

        return counter;
    }
}
