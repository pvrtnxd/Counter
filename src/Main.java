import java.text.BreakIterator;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        int words = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Ваше предложение:");
        System.out.println(splitText(sc.nextLine()));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            arrayList.add(line);
            words += line.split(" ").length;
            System.out.println("Строка " + arrayList.size());
            System.out.println("Cлов " + words);


        }
    }


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

        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
        sorted.addAll(words.entrySet());
        System.out.println(sorted);

        return null;
    }




}
