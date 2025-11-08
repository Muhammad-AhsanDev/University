import java.util.HashSet;
import java.util.Iterator; 

public class hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");
        set.add("Pineapple");
 set.remove("Apple");
        // Using Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
       
        // Checking HashSet methods
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Apple"));
    }
}
