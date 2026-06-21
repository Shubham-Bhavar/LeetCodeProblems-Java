/*
LeetCode 705 - Design HashSet

Implement a HashSet without using built-in hash table libraries.

Methods:
- add(key): Insert key into the set.
- remove(key): Remove key from the set.
- contains(key): Return true if key exists, otherwise false.
*/

class MyHashSet {

    // Constraints: 0 <= key <= 10^6
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    // Add the key to the HashSet
    public void add(int key) {
        set[key] = true;
    }

    // Remove the key from the HashSet
    public void remove(int key) {
        set[key] = false;
    }

    // Check whether the key exists
    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
