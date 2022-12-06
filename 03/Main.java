
// From: https://gist.github.com/TilakMaddy/e298fa3fe6f4c5e1e897c9e69f531088
/*
 * No package must be added here because some Online Judges don't support it
 * please remove, if any.
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// Additional packages
import java.lang.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class Main {

    /*
     * In a Programming contest, you are expected to print the output at the end, so
     * `output` variable will hold all the processed results till the end
     */
    public static Integer result = 0;

    // Program's starting point
    public static void main(String[] args) {

        /*
         * A Scanner class slows down Input/Output a LOT ,thereby increasing your code
         * execution time , Hence for best results that is Fast I/O try to use
         * BufferedReader
         */
        // File file = new File("tc.txt");
        File file = new File("input.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            /*
             * Generally Code Chef, Hacker Rank gives X number of test cases so we process
             * the input for each.
             */
            // final int cases;
            try {
                // cases = Integer.parseInt(br.readLine().trim());
                /*
                 * Logic of the program must be separated from the meta code to increase
                 * readability and help debugging easier Also note that Solver object is created
                 * inside for loop to avoid multiple object creation that drastically increases
                 * execution time and memory usage
                 */
                Solver solver = new Solver();

                // for (int i = 0; i < cases; i++) {
                // solver.solve(br.readLine());
                // }
                String line;
                while ((line = br.readLine()) != null) {
                    solver.solve(line);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Print the final output
        System.out.println("Result: " + result);

    }

}

/*
 * Some basic rules while coding in Programming Contests: Try to follow at least
 * 80% of them Correctness - final declaration for required data types - avoid
 * Object creation - Scanner slows down, use InputReader - avoid too many static
 * functions Efficiency - use library functions as much as possible -
 * assertEquals("RESULT", functionToCall()) Debugging-ability - avoid too many
 * global variables - Separate logic from meta-processing - variable/function
 * pneumonics must make sense
 * 
 */
class Solver {
    public static Map<Character, Integer> map1 = new HashMap<Character, Integer>();
    public static Map<Character, Integer> map2 = new HashMap<Character, Integer>();

    // Lowercase item types a through z have priorities 1 through 26.
    // Uppercase item types A through Z have priorities 27 through 52.

    /*
     * Logic goes here ... Add to the global variables after processing the input
     * Maybe reverse a string or parse to an integer or , etc.
     */
    public void solve(String input) {
        map1 = new HashMap<Character, Integer>();
        map2 = new HashMap<Character, Integer>();
        // System.out.println(input);

        char[] arr = input.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            char c1 = arr[i];
            map1.put((char) c1, map1.getOrDefault((char) c1, 0) + 1);
            char c2 = arr[i + len / 2];
            map2.put((char) c2, map2.getOrDefault((char) c2, 0) + 1);
        }

        // System.out.println(
        // "map1" + map1.entrySet().stream().map(e ->
        // e.getKey().toString()).collect(Collectors.joining()));
        // System.out.println(
        // "map2" + map2.entrySet().stream().map(e ->
        // e.getKey().toString()).collect(Collectors.joining()));

        // System.out.println(map1);
        // System.out.println(map2);

        for (Entry<Character, Integer> entrySet : map1.entrySet()) {
            Character c = entrySet.getKey();
            if (map2.containsKey(c)) {
                System.out.println("found: " + c);
                Main.result += getPrioScore(c);
                break;
            }
        }
        // Main.output += input;
    }

    int getPrioScore(Character c) {
        return (int) c >= 97 ? c - 96 : c - 38;
    }
}