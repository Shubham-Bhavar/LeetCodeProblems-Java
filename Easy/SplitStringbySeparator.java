    /*
    ❓ Goal: Split all words using given separator
    ❓ Ignore: empty strings after split
    ❓ Maintain: original order
    ❓ Return: list of valid strings
    */
import java.util.*;

class Solution {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            // Convert char to string for split
            String[] parts = word.split("\\" + separator);

            for (String part : parts) {

                // Ignore empty strings
                if (!part.equals("")) {
                    result.add(part);
                }
            }
        }

        return result;
    }
}
