import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Hamming h = new Hamming();
//        Levenshtein l = new Levenshtein();
//        CSVReader csv = new CSVReader();
//
//        Distancer d = new Distancer(h, csv);
//        // System.out.println(d.findWord("prodcerp"));
//
//        BagOfWords b = new BagOfWords();

        List<String> words1 = new ArrayList<>();
        words1.add("Who");
        words1.add("is");
        words1.add("author");
        words1.add("of");
        words1.add("the");
        words1.add("of");

        List<String> words2 = new ArrayList<>();
        words2.add("Hello");
        words2.add("is");
        words2.add("author");
        words2.add("of");
        words2.add("books");

//        CosineSimilarity cosSim = new CosineSimilarity(b);
        // System.out.println(cosSim.similarity(words1, words2));

        // ----- S8
//        List<String> list = csv.read(1);
//        List<csvThread> listThreads = new ArrayList<>();
//
//        int nrThreads = 5;
//        String search = "alo";
//        int chunk = list.size()/nrThreads;
//
//        int i = 0;
//        for (i = 0; i < nrThreads; i++) {
//            csvThread thread = new csvThread(list.subList(i * chunk, (i + 1) * chunk), h,search);
//            listThreads.add(thread);
//            thread.start();
//        }
//
//        if (list.size() % nrThreads != 0) {
//            csvThread thread = new csvThread(list.subList(i * chunk, list.size()), h,search);
//            listThreads.add(thread);
//            thread.start();
//        }
//
//        String minWord = "";
//        double minDistance = Double.MAX_VALUE;
//        for (csvThread thread: listThreads) {
//            thread.join();
//            if (thread.getMin() < minDistance) {
//                minDistance = thread.getMin();
//                minWord = thread.getMatch();
//            }
//        }
//
//        System.out.println(minDistance);
//        System.out.println(minWord);

        JavaFX fx = new JavaFX();
        fx.run();
    }
}
