package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class DesignHashset705 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }

    static class MyHashSet {
        private final int BUCKET_SIZE = 15;
        private List<Integer>[] buckets;

        public MyHashSet() {
            buckets = new LinkedList[BUCKET_SIZE];
            for (int i = 0; i < BUCKET_SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            int index = hash(key);
            if (!contains(key)) {
                buckets[index].add(key);
            }
        }

        public void remove(int key) {
            int index = hash(key);
            buckets[index].remove((Integer) key);
        }

        public boolean contains(int key) {
            int index = hash(key);
            return buckets[index].contains(key);
        }

        private int hash(int key) {
            return key % BUCKET_SIZE;
        }
    }
}
