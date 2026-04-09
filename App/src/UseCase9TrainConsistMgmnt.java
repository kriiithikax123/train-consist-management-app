import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ==================================================
 * MAIN CLASS - UseCase9TrainConsistMgmnt
 * ==================================================
 *
 * Use Case 9: Group Bogies by Type (Collectors.groupingBy)
 *
 * Description:
 * This class groups passenger bogies into categories
 * using the Java Stream Collectors.groupingBy() operation.
 *
 * At this stage, the application:
 * - Creates a list of bogie objects
 * - Converts list to a stream
 * - Applies groupingBy() collector
 * - Stores result in a Map<String, List<Bogie>>
 * - Displays grouped bogie structure
 *
 * @author Developer
 * @version 9.0
 */

public class UseCase9TrainConsistMgmnt {

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
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("========================================\n");

        // Create list of passenger bogies (with duplicates for grouping)
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogie objects (including same types) ----
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("General", 90));

        // ---- DISPLAY original list ----
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- GROUP using Collectors.groupingBy() ----
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // ---- DISPLAY grouped result ----
        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  -> " + b.name + " | Capacity: " + b.capacity);
            }
        }

        // ---- Group size summary ----
        System.out.println("\nGroup Size Summary:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size() + " bogie(s)");
        }

        // ---- Verify original list is unchanged ----
        System.out.println("\nOriginal List Size (Unchanged): " + bogies.size());

        System.out.println("\nUC9 grouping completed...");
    }
}