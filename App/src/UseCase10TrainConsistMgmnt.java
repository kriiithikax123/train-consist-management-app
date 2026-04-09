import java.util.ArrayList;
import java.util.List;

/**
 * ==================================================
 * MAIN CLASS - UseCase10TrainConsistMgmnt
 * ==================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 *
 * Description:
 * This class aggregates seating capacities of all bogies
 * into a single total value using Stream reduction.
 *
 * At this stage, the application:
 * - Creates a list of bogie objects
 * - Converts list to a stream
 * - Applies map() to extract capacity values
 * - Uses reduce() to sum all capacities
 * - Displays total seating capacity
 *
 * @author Developer
 * @version 10.0
 */

public class UseCase10TrainConsistMgmnt {

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
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("========================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogie objects ----
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // ---- DISPLAY all bogies ----
        System.out.println("Bogie Capacity Details:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity + " seats");
        }

        // ---- AGGREGATE using map() + reduce() ----
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // ---- DISPLAY total ----
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats + " seats");

        // ---- Verify original list is unchanged ----
        System.out.println("\nOriginal List Size (Unchanged): " + bogies.size());

        System.out.println("\nUC10 seat aggregation completed...");
    }
}
