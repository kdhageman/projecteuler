package core;

import solutions.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Solution> problems;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Provide a problem number");
            return;
        }

        initSolutions();

        try {
            int problemNumber = Integer.parseInt(args[0]);
            long start = System.currentTimeMillis();
            if (problems.containsKey(problemNumber)) {
                problems.get(problemNumber).solve();
            } else {
                System.out.println("Cannot find specified problem");
                return;
            }

            long end = System.currentTimeMillis();
            System.out.format("Took %d ms in total\n", end-start);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void initSolutions(){
        problems = new HashMap<>();
        problems.put(12, new Problem12());
        problems.put(13, new Problem13());
        problems.put(14, new Problem14());
        problems.put(15, new Problem15());
        problems.put(16, new Problem16());
        problems.put(17, new Problem17());
    }
}
