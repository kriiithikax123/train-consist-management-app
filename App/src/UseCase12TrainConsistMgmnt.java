import java.util.ArrayList;
import java.util.List;

/**
 * ==================================================
 * MAIN CLASS - UseCase12TrainConsistMgmnt
 * ==================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces cargo safety rules for goods bogies
 * using Stream allMatch() and lambda-based conditional logic.
 *
 * At this stage, the application:
 * - Creates a list of goods bogie objects
 * - Converts list to a stream
 * - Applies allMatch() with safety rule logic
 * - Cylindrical bogies must carry only Petroleum
 * - Displays whether the train is safety compliant
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12TrainConsistMgmnt {

    // Inner GoodsBogie class with type and cargo fields
    static class GoodsBogie {
        String type;   // e.g. Cylindrical, Open, Box
        String cargo;  // e.g. Petroleum, Coal, Grain

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // ---- Safety Validation Method ----
    public static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC12 - Safety Compliance Check ");
        System.out.println("========================================\n");

        // ---- SCENARIO 1: All bogies valid ----
        List<GoodsBogie> safeFormation = new ArrayList<>();
        safeFormation.add(new GoodsBogie("Cylindrical", "Petroleum"));
        safeFormation.add(new GoodsBogie("Open", "Coal"));
        safeFormation.add(new GoodsBogie("Box", "Grain"));
        safeFormation.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Scenario 1 - Safe Formation:");
        for (GoodsBogie b : safeFormation) {
            System.out.println("  Type: " + b.type + " | Cargo: " + b.cargo);
        }
        boolean result1 = isSafetyCompliant(safeFormation);
        System.out.println("Safety Compliant: " + result1);
        System.out.println(result1 ? "Train is SAFE for operation.\n"
                                   : "WARNING: Train formation is UNSAFE!\n");

        // ---- SCENARIO 2: Cylindrical bogie with invalid cargo ----
        List<GoodsBogie> unsafeFormation = new ArrayList<>();
        unsafeFormation.add(new GoodsBogie("Cylindrical", "Petroleum"));
        unsafeFormation.add(new GoodsBogie("Cylindrical", "Coal"));  // Violation
        unsafeFormation.add(new GoodsBogie("Open", "Grain"));

        System.out.println("Scenario 2 - Unsafe Formation:");
        for (GoodsBogie b : unsafeFormation) {
            System.out.println("  Type: " + b.type + " | Cargo: " + b.cargo);
        }
        boolean result2 = isSafetyCompliant(unsafeFormation);
        System.out.println("Safety Compliant: " + result2);
        System.out.println(result2 ? "Train is SAFE for operation.\n"
                                   : "WARNING: Train formation is UNSAFE!\n");

        // ---- SCENARIO 3: Empty bogie list ----
        List<GoodsBogie> emptyFormation = new ArrayList<>();
        boolean result3 = isSafetyCompliant(emptyFormation);
        System.out.println("Scenario 3 - Empty Formation:");
        System.out.println("Safety Compliant: " + result3);
        System.out.println(result3 ? "Train is SAFE for operation.\n"
                                   : "WARNING: Train formation is UNSAFE!\n");

        System.out.println("UC12 safety compliance check completed...");
    }
}