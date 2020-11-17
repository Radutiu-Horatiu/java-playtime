import java.util.ArrayList;
import java.util.List;

public class CosineSimilarity implements Similarity{

    private Vectorizer v;

    public CosineSimilarity(Vectorizer v) {
        this.v = v;
    }

    @Override
    public double similarity(List<String> sentence1, List<String> sentence2) {

        List<String> newList = new ArrayList<String>(sentence1);
        newList.addAll(sentence2);

        v.buildVocabulary(newList);

        List<Double> sentence_A = v.transform(sentence1);
        List<Double> sentence_B = v.transform(sentence2);

        double n1 = 0;
        double n2 = 0;
        double sum = 0;
        for (int i = 0; i < sentence_A.size(); i++) {
            sum += sentence_A.get(i) * sentence_B.get(i);
            n1  += sentence_A.get(i) * sentence_A.get(i);
            n2  += sentence_B.get(i) * sentence_B.get(i);
        }

        return sum/(Math.sqrt(n1)*Math.sqrt(n2));
    }
}
