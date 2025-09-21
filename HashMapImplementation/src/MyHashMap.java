import java.util.ArrayList;

public class MyHashMap<K, V> {

    int minimum_size = 1<<16;
    int maximum_size = 1<<30;
    int capacity;
    int nodes_filled;
    HashNode<K,V>[] hash_map;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.nodes_filled = 0;
        this.capacity = FindCapacity(capacity);
        hash_map = (HashNode<K, V>[]) new HashNode[this.capacity];
    }

    public MyHashMap() {
        this.capacity = this.minimum_size;
        this.nodes_filled = 0;
        hash_map = (HashNode<K, V>[]) new HashNode[this.capacity];
    }

    private int FindCapacity(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return Math.min(n + 1, maximum_size);
    }

    public int GetIndex(K key){
        int h;
        int hash_key =  ((h = key.hashCode()) & (h >>> 16));
        return hash_key & (capacity - 1);
    }

    public void Set(K key, V value) {
        int index = GetIndex(key);
        if (hash_map[index] == null) {
            HashNode<K, V> new_node = new HashNode<>(key, value);
            hash_map[index] = new_node;
            this.nodes_filled++;
            ReAdjustLoadFactor();
        } else {
            K node_key = hash_map[index].GetKey();
            if (node_key == key) {
                hash_map[index].SetValue(value);
            } else {
                HashNode<K, V> new_node = new HashNode<>(key, value);
                HashNode<K, V> old_node = hash_map[index];
                old_node.SetNextNode(new_node);
            }
        }
    }

    public V Get (K key) {
        int index = GetIndex(key);
        HashNode<K, V> node = hash_map[index];
        while(node != null && node.GetKey() != key) {
            node = node.GetNextNode();
        }
        if (node == null) {
            return null;
        } else {
            return node.GetValue();
        }
    }

    public void Remove (K key) {
        int index = GetIndex(key);
        HashNode<K, V> curr_node = hash_map[index];
        HashNode<K, V> prev_node = null;
        while(curr_node != null && curr_node.GetKey() != key) {
            prev_node = curr_node;
            curr_node = curr_node.GetNextNode();
        }
        if (curr_node != null){
            if (prev_node != null) {
                prev_node.SetNextNode(curr_node.GetNextNode());
            } else if (curr_node.GetNextNode() == null) {
                this.hash_map[index] = null;
                nodes_filled--;
            }
        } else {
            System.out.print("No key to remove\n");
        }
    }

    public int GetCapacity(){
        return this.capacity;
    }

    public void ReAdjustLoadFactor() {
        if(nodes_filled >= 0.75*this.capacity) {
            this.capacity = this.capacity*2;
            // need rehashing of all key and remapping as size has changed.
        }
    }

}
