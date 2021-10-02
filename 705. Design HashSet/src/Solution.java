/*
* Design a HashSet without using any built-in hash table libraries.
*
* Implement MyHashSet class:
*   void add(key) Inserts the value key into the HashSet.
*   bool contains(key) Returns whether the value key exists in the HashSet or not.
*   void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*
* Constraints:
*   0 <= key <= 106
*   At most 104 calls will be made to add, remove, and contains.
* */

class MyHashSet {
    boolean[] buckets;
    public static int capacity = 1000001;

    public MyHashSet() {
        buckets = new boolean[capacity];
    }

    public void add(int key) {
        buckets[key] = true;
    }

    public void remove(int key) {
        buckets[key] = false;
    }

    public boolean contains(int key) {
        return buckets[key];
    }
}