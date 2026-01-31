package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class DesignHashMap706 {
    public static void main(String[] args) {
        final MyHashMap myHashMap= new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    static class MyHashMap {

        private final int BUCKET_SIZE = 15;
        private List<Pair>[] buckets;

        public MyHashMap() {
            buckets = new LinkedList[BUCKET_SIZE];
            for (int i = 0; i < BUCKET_SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }

        }

        public void put(int key, int value) {
            int hash = hash(key);
            if(get(key) != -1){
                remove(key);
            }

            buckets[hash].add( new Pair(key, value));

        }

        public int get(int key) {
            int hash = hash(key);

            for (Pair element: buckets[hash]) {
                if(element.key == key){
                    return element.value;
                }
            }

            return -1;
        }

        public void remove(int key) {
            int hash = hash(key);

            buckets[hash]
                    .removeIf(pair -> pair.key == key);
        }

        private int hash(int key){
            return key % BUCKET_SIZE;
        }
    }

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
