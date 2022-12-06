
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
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * Only classes with 'Main' name are accepted in CodeChef and some other online judges
 */
public class Main {

    /*
     * In a Programming contest, you are expected to print the output at the end, so
     * `output` variable will hold all the processed results till the end
     */

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

                for (int i = 0; i < 9; i++) {
                    System.out.print(solver.stack[i].peek());
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

    public static int maxSum = 0;
    public static int tempSum = 0;
    public static Stack<Character>[] stack = new Stack[9];

    public void init() {
        for (int i = 0; i < 9; i++) {
            stack[i] = new Stack<>();
        }
    }

    /*
     * Logic goes here ... Add to the global variables after processing the input
     * Maybe reverse a string or parse to an integer or , etc.
     */
    public void solve(String input) {
        if (input.startsWith("move")) {
            for (int i = 0; i < 9; i++) {
                System.out.println("[" + i + "] " + stack[i]);
            }

            Pattern r = Pattern.compile("\\d+");
            Matcher m = r.matcher(input);
            m.find();
            int n = Integer.parseInt(m.group());
            m.find();
            int from = Integer.parseInt(m.group()) - 1;
            m.find();
            int to = Integer.parseInt(m.group()) - 1;

            System.out.println("move " + n + " from " + from + " to " + to);

            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = stack[from].pop();
            }

            for (int i = n - 1; i >= 0; i--) {
                stack[to].push(arr[i]);
            }

            for (int i = 0; i < 9; i++) {
                System.out.println("[" + i + "] " + stack[i]);
            }
        } else {
            char[] arr = input.toCharArray();
            System.out.println(Arrays.toString(arr));

            int idx = 0;
            for (int i = 1; i < arr.length; i += 4) {
                if (arr[i] != ' ') {
                    stack[idx].push(arr[i]);
                }

                idx++;
            }
        }
    }
}