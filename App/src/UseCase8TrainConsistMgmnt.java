import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ==================================================
 * MAIN CLASS - UseCase8TrainConsistMgmnt
 * ==================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using the Java Stream API.
 *
 * At this stage, the application:
 * - Creates a list of bogie objects
 * - Converts list to a stream
 * - Applies filter() with capacity condition
 * - Collects filtered results into a new list
 * - Displays filtered bogies
 *
 * @author Developer
 * @version 8.0
 */

public class UseCase8TrainConsistMgmnt {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("========================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogie objects ----
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // ---- DISPLAY original list ----
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- FILTER using Stream API (capacity > 60) ----
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // ---- DISPLAY filtered result ----
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- Verify original list is unchanged ----
        System.out.println("\nOriginal List Size (Unchanged): " + bogies.size());

        System.out.println("\nUC8 stream filtering completed...");
    }
}