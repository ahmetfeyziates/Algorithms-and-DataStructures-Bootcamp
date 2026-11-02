import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTutorial {

    public static void main(String[] args) {

        // ==========================================================
        // 1. CREATION
        // ==========================================================
        // Best practice: Program to the interface (List<String>)
        List<String> fruits = new ArrayList<>();

        System.out.println("--- 1. Adding Elements ---");
        // add(element) -> Appends to the end: O(1) amortized
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // add(index, element) -> Inserts at position: O(n) due to shifting
        fruits.add(1, "Blueberry"); 

        System.out.println("Current list: " + fruits);
        System.out.println("Current size: " + fruits.size());

        // ==========================================================
        // 2. ACCESSING & UPDATING
        // ==========================================================
        System.out.println("\n--- 2. Access & Update ---");
        // get(index) -> O(1) constant time random access
        String firstItem = fruits.get(0);
        System.out.println("Item at index 0: " + firstItem);

        // set(index, newElement) -> Replaces existing element: O(1)
        fruits.set(2, "Strawberry"); // Replaces "Banana"
        System.out.println("After update: " + fruits);

        // ==========================================================
        // 3. SEARCHING & INSPECTION
        // ==========================================================
        System.out.println("\n--- 3. Searching ---");
        // contains(element) -> Checks presence: O(n)
        boolean hasMango = fruits.contains("Mango");
        System.out.println("Contains 'Mango'? " + hasMango);

        // indexOf(element) -> Returns index, or -1 if not found: O(n)
        int orangeIndex = fruits.indexOf("Orange");
        System.out.println("Index of 'Orange': " + orangeIndex);

        // ==========================================================
        // 4. REMOVING ELEMENTS
        // ==========================================================
        System.out.println("\n--- 4. Removal ---");
        // remove(index) -> Removes by position: O(n)
        String removedItem = fruits.remove(1); // Removes "Blueberry"
        System.out.println("Removed item: " + removedItem);

        // remove(Object) -> Removes the first matching object: O(n)
        fruits.remove("Orange");
        System.out.println("After removals: " + fruits);

        // ==========================================================
        // 5. ITERATION TECHNIQUES
        // ==========================================================
        System.out.println("\n--- 5. Iteration ---");

        // Approach A: Enhanced for-loop (Most common)
        System.out.print("Enhanced for-loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Approach B: Java 8+ forEach with Lambda
        System.out.print("Lambda forEach:     ");
        fruits.forEach(f -> System.out.print(f + " "));
        System.out.println();

        // Approach C: Traditional index loop (Needed if you need indices)
        System.out.print("Indexed for-loop:   ");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("[" + i + ":" + fruits.get(i) + "] ");
        }
        System.out.println();

        // ==========================================================
        // 6. UTILITIES (SORTING & REVERSING)
        // ==========================================================
        System.out.println("\n--- 6. Utilities ---");
        Collections.sort(fruits);
        System.out.println("Alphabetically sorted: " + fruits);

        Collections.reverse(fruits);
        System.out.println("Reversed order:        " + fruits);

        // ==========================================================
        // 7. CLEANUP
        // ==========================================================
        System.out.println("\n--- 7. Cleanup ---");
        fruits.clear();
        System.out.println("Is list empty now? " + fruits.isEmpty());
    }
}
