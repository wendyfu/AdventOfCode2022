
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
import java.util.HashMap;
import java.util.Map;

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
                solver.init();

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

    // A for Rock, B for Paper, and C for Scissors.
    // X for Rock, Y for Paper, and Z for Scissors
    // 1 for Rock, 2 for Paper, and 3 for Scissors
    // (0 if you lost, 3 if the round was a draw, and 6 if you won).
    public static int maxSum = 0;

    int X = 1, Y = 2, Z = 3;

    public static Map<String, Integer> map = new HashMap<String, Integer>();

    public void init() {
        map.put("A X", (3 + X));
        map.put("A Y", (6 + Y));
        map.put("A Z", (0 + Z));

        map.put("B X", (0 + X));
        map.put("B Y", (3 + Y));
        map.put("B Z", (6 + Z));

        map.put("C X", (6 + X));
        map.put("C Y", (0 + Y));
        map.put("C Z", (3 + Z));
    }

    /*
     * Logic goes here ... Add to the global variables after processing the input
     * Maybe reverse a string or parse to an integer or , etc.
     */
    public void solve(String input) {
        // System.out.println(input);
        maxSum += map.get(input);
        Main.result = maxSum;
        // Main.output += input;
    }

}