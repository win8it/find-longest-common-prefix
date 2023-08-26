import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public static void main(String[] args) {
            // Press Alt+Enter with your caret at the highlighted text to see how
            // IntelliJ IDEA suggests fixing it.
            var example1 = List.of("flower","flow","flight");
            var acutal1 = findLongestCommonPrefix(example1);
            var expected1 = "fl";
            System.out.printf("We expected %s, and we got %s%n",  expected1, acutal1);
            var example2 = List.of("flower","flog","floght");
            var acutal2 = findLongestCommonPrefix(example2);
            var expected2 = "flo";
            System.out.printf("We expected %s, and we got %s%n",  expected2, acutal2);
            var example3 = List.of("");
            var acutal3 = findLongestCommonPrefix(example3);
            var expected3 = "";
            System.out.printf("We expected %s, and we got %s%n",  expected3, acutal3);

        }

        /**
         * @param list to find
         * @return
         */
        public static String findLongestCommonPrefix(final List<String> list){
            String longestCommonPrefix = "";
            if (list == null || list.isEmpty()) {
                return longestCommonPrefix;
            }
            String firstItem = list.get(0);
            if (list.size() == 1) {
                return firstItem;
            }
            int numberOfIteration = list.stream().map(it -> it.toCharArray().length).min(Integer::compare).orElse(0);
            for (int i = 0; i < numberOfIteration; i++) {
                char currentChar = firstItem.charAt(i);
                String prefix = longestCommonPrefix + currentChar;
                boolean currentCharAccepted = list.stream().allMatch(item -> item.startsWith(prefix));
                if (currentCharAccepted) {
                    longestCommonPrefix = prefix;
                }
            }
                return longestCommonPrefix;
        }
}