package algorithms;

import java.util.Arrays;
import java.util.List;

public class AvgElements {
    // there is an List with numbers as strings, find average of numbers

    public int findAvgIntV1(List<Integer> lst) {
        return (int) lst.stream().mapToInt(x -> x).average().getAsDouble();
    }

    // Without lambdas
    public int findAvgIntV2(List<Integer> lst) {
        int sum = 0;
        for (int i : lst) {
            sum += i;
        }
        if (lst.isEmpty()) {
            throw new Error("List is empty");
        } else {
            return (int) (sum / (float) lst.size());
        }
    }

    public int findAvgStr(List<String> lst) {
//        '.mapToInt(x -> Integer.parseInt(x))' have been converted to '.mapToInt(Integer::parseInt)'
        return (int) lst.stream().mapToInt(Integer::parseInt).average().getAsDouble();
    }
}
