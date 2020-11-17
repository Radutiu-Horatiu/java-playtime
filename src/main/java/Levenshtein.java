import java.util.Arrays;

// The Levenshtein distance is a measure of dissimilarity between two Strings.
// Mathematically, given two Strings x and y, the distance
// measures the minimum number of character edits required to transform x into y.
public class Levenshtein implements Distance {

    @Override
    public double compute(String s1, String s2) {
        if (s1.isEmpty()) {
            return s2.length();
        }

        if (s2.isEmpty()) {
            return s1.length();
        }

        int substitution = (int) (compute(s1.substring(1), s2.substring(1))
                        + costOfSubstitution(s1.charAt(0), s2.charAt(0)));
        int insertion = (int) (compute(s1, s2.substring(1)) + 1);
        int deletion = (int) (compute(s1.substring(1), s2) + 1);

        return min(substitution, insertion, deletion);
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
