import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ==================================================
 * MAIN CLASS - UseCase11TrainConsistMgmnt
 * ==================================================
 *
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 *
 * Description:
 * This class validates Train ID and Cargo Code formats
 * using Regular Expressions with Pattern and Matcher.
 *
 * At this stage, the application:
 * - Defines regex patterns for Train ID and Cargo Code
 * - Compiles patterns using Pattern class
 * - Creates Matcher objects for input validation
 * - Uses matches() to verify format correctness
 * - Displays validation results
 *
 * @author Developer
 * @version 11.0
 */

public class UseCase11TrainConsistMgmnt {

    // ---- Regex Patterns ----
    // Train ID: TRN- followed by exactly 4 digits
    private static final String TRAIN_ID_PATTERN = "TRN-\\d{4}";

    // Cargo Code: PET- followed by exactly 2 uppercase letters
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    // ---- Validation Methods ----
    public static boolean validateTrainID(String trainID) {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("========================================\n");

        // ---- TEST Train ID Validation ----
        System.out.println("Train ID Validation:");
        System.out.println("--------------------");

        String[] trainIDs = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345", ""};
        for (String id : trainIDs) {
            String result = validateTrainID(id) ? "Valid" : "Invalid";
            System.out.println("Train ID: \"" + id + "\" -> " + result);
        }

        // ---- TEST Cargo Code Validation ----
        System.out.println("\nCargo Code Validation:");
        System.out.println("----------------------");

        String[] cargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC", ""};
        for (String code : cargoCodes) {
            String result = validateCargoCode(code) ? "Valid" : "Invalid";
            System.out.println("Cargo Code: \"" + code + "\" -> " + result);
        }

        System.out.println("\nUC11 validation completed...");
    }
}
