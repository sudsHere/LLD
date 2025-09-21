public class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next_node;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next_node = null;
    }

    public K GetKey() {
        return this.key;
    }

    public V GetValue() {
        return this.value;
    }

    public void SetValue(V value){
        this.value = value;
    }

    public void SetNextNode(HashNode<K,V> node) {
        this.next_node = node;
    }

    public HashNode<K,V> GetNextNode() {
        return this.next_node;
    }
}
