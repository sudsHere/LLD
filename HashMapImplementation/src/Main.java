//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> local_hash_map_1 = new MyHashMap<>(20); // we do not want to give capacity
        MyHashMap<Integer, String> local_hash_map_2 = new MyHashMap<>();

        local_hash_map_1.Set("Suds", "confused");
        local_hash_map_1.Set("Hyderabad", "biryani");
        local_hash_map_1.Set("ranchi", "raining");

        String value = local_hash_map_1.Get("Suds");
        System.out.printf("value for suds is: %s\n", value);
        value = local_hash_map_1.Get("rubbish");
        System.out.printf("value for rubbish is: %s\n", value);

        int capacity = local_hash_map_1.GetCapacity();
        System.out.printf("Capacity of localhashMap1 is: %d\n", capacity);

        value = local_hash_map_1.Get("ranchi");
        System.out.printf("value for ranchi before removal is: %s\n", value);
        // remove
        local_hash_map_1.Remove("ranchi");
        value = local_hash_map_1.Get("ranchi");
        System.out.printf("value for ranchi after key removed is: %s\n", value);

        // hash map 2
        local_hash_map_2.Set(1, "suds");
        local_hash_map_2.Set(2, "hyderabad");
    }
}