
/*
 * LeetCode 535: Encode and Decode TinyURL
 *
 * Problem:
 * Encode a long URL into a short URL and decode
 * the short URL to get the original URL.
 *
 * Approach:
 * 1. Generate a unique ID for each URL.
 * 2. Store the mapping: ID -> original URL.
 * 3. Return the short URL containing that ID.
 * 4. Decode by retrieving the original URL from the map.
 *
 * Time Complexity:
 * encode: O(1) average
 * decode: O(1) average
 *
 * Space Complexity: O(n * L)
 * n = number of URLs stored
 * L = average URL length
 */

import java.util.HashMap;
import java.util.Map;

public class Codec {
    private final Map<String, String> urlMap = new HashMap<>();
    private int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(counter++);
        urlMap.put(key, longUrl);

        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(
                shortUrl.lastIndexOf('/') + 1);

        return urlMap.get(key);
    }
}
