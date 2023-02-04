import java.text.BreakIterator;
import java.util.*;

public class Sort {
    public static List<String> splitText(String text) {
        Map<String, Integer> words = new HashMap<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                String word = text.substring(firstIndex, lastIndex);
                words.merge(word, 1, Integer::sum);
            }
        }
        // отсортировать по убыванию частоты а затем в алфавитном порядке
        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(
                Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())
        );
        sorted.addAll(words.entrySet());
        System.out.println(sorted);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : sorted) {
            result.add(e.getKey());
        }
        return result;
    }

}
