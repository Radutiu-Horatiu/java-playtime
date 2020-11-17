import java.util.stream.IntStream;

import static java.lang.Integer.min;

public class Hamming implements Distance {
    @Override
    public double compute(String s1, String s2) {
        int dist_counter = 0;
        int lim = Math.min(s1.length(), s2.length());
        return IntStream.range(0, lim)
            .filter(i -> s1.charAt(i) != s2.charAt(i))
            .count() + Math.abs(s1.length() - s2.length());
        
//        for (int i = 0;i < lim;i++)
//            if(s1.charAt(i) != s2.charAt(i)){
//                dist_counter += 1;
//        }
//
//        int lengthDiff = Math.abs(s1.length() - s2.length());
//        return dist_counter + lengthDiff;
    }
}
