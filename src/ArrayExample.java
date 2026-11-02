import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {

        // ==========================================================
        // 1. DECLARATION & ALLOCATION
        // ==========================================================
        // Fixed capacity: size cannot be changed after instantiation
        int[] scores = new int[5]; // Elements default to 0

        // Array literal initializer syntax
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};

        System.out.println("Array length: " + fruits.length); // .length is a field, not a method

        // ==========================================================
        // 2. DIRECT ACCESS & MUTATION (O(1))
        // ==========================================================
        System.out.println("\n--- Access & Update ---");
        // Read
        String firstFruit = fruits[0];
        System.out.println("Element at index 0: " + firstFruit);

        // Update
        fruits[1] = "Strawberry";
        System.out.println("Updated index 1: " + fruits[1]);

        // Writing to fixed integer array
        scores[0] = 88;
        scores[1] = 92;
        scores[2] = 79;

        // ==========================================================
        // 3. BOUNDS ENFORCEMENT
        // ==========================================================
        try {
            // Valid indices: 0 through length - 1 (here: 0 to 3)
            String invalid = fruits[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCaught expected error: " + e.getMessage());
        }

        // ==========================================================
        // 4. ITERATION
        // ==========================================================
        System.out.println("\n--- Iteration ---");
        // Indexed for-loop (allows tracking position)
        System.out.print("Indexed for-loop: ");
        for (int i = 0; i < fruits.length; i++) {
            System.out.print("[" + i + ":" + fruits[i] + "] ");
        }
        System.out.println();

        // Enhanced for-loop (for-each)
        System.out.print("Enhanced for-loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // ==========================================================
        // 5. UTILITY OPERATIONS (java.util.Arrays)
        // ==========================================================
        System.out.println("\n--- java.util.Arrays Utilities ---");
        int[] numbers = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 45, 8};

        // Pretty printing (printing an array directly prints its memory reference hash)
        System.out.println("Before sort: " + Arrays.toString(numbers));

        // In-place dual-pivot quicksort: O(n log n)
        Arrays.sort(numbers);
        System.out.println("After sort:  " + Arrays.toString(numbers));

        // Binary search: requires sorted array, returns index or negative insertion point: O(log n)
        int targetIndex = Arrays.binarySearch(numbers, 42);
        System.out.println("Index of 42: " + targetIndex);

        // Copying / Resizing simulation (allocates a new array behind the scenes)
        int[] expanded = Arrays.copyOf(numbers, numbers.length * 2);
        System.out.println("Expanded array capacity: " + expanded.length);

        // ==========================================================
        // 6. MULTIDIMENSIONAL ARRAYS (ARRAYS OF ARRAYS)
        // ==========================================================
        System.out.println("\n--- Multidimensional Matrix ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Element at row 1, col 2: " + matrix[1][2]); // 6
        System.out.println("Full matrix: " + Arrays.deepToString(matrix));
    }
}
