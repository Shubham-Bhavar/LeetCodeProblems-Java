
/*
 * LeetCode 1352: Product of the Last K Numbers
 *
 * Problem:
 * Design a data structure that supports adding numbers to a stream
 * and finding the product of the last k numbers.
 *
 * Approach:
 * Use Prefix Products.
 *
 * Step-by-Step Explanation:
 * 1. Store prefix products in an ArrayList.
 * 2. Initially, store 1 because it is the starting product.
 * 3. When a non-zero number is added, multiply it with the
 *    previous prefix product and store the result.
 * 4. When zero is added, clear the list and add 1 again.
 * 5. For getProduct(k):
 *    - If k is greater than the current list size - 1,
 *      the last k numbers contain zero, so return 0.
 *    - Otherwise, divide the latest prefix product by the
 *      prefix product before the last k numbers.
 *
 * Note:
 * Clearing the prefix products after zero makes it easy to
 * handle products containing zero.
 *
 * Time Complexity:
 * add()        : O(1)
 * getProduct() : O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.*;

class ProductOfNumbers {

    private List<Integer> prefix;

    public ProductOfNumbers() {

        prefix = new ArrayList<>();

        // Initial prefix product
        prefix.add(1);
    }

    public void add(int num) {

        // If number is zero, reset prefix products
        if (num == 0) {

            prefix.clear();
            prefix.add(1);

        } else {

            int lastProduct = prefix.get(prefix.size() - 1);

            prefix.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {

        int size = prefix.size();

        // If k numbers include a zero
        if (k >= size) {
            return 0;
        }

        // Product of last k numbers
        return prefix.get(size - 1) / prefix.get(size - 1 - k);
    }
}
