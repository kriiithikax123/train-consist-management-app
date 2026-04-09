import java.util.LinkedList;
import java.util.List;

public class UC4OrderedBogieConsist {
    public static void main(String[] args) {
        // Display welcome banner
        System.out.println("========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("========================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        List<String> trainConsist = new LinkedList<>();

        // ---- ADD bogies in order ----
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // ---- READ Initial Consist ----
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // ---- INSERT Pantry Car at position 2 ----
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // ---- REMOVE First and Last bogie ----
        ((LinkedList<String>) trainConsist).removeFirst();
        ((LinkedList<String>) trainConsist).removeLast();
        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}