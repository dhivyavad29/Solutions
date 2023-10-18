import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EcologicalCar {
    public static int solution(int[] P, int[] S) {
        int c = 0;
        int p = Arrays.stream(P).sum();
        List<Integer> seats = new ArrayList<Integer>();

        for (int s : S) {
            seats.add(s);
        }

        Collections.sort(seats, Collections.reverseOrder());

        while (p > 0) {
            int s = seats.get(0);
            p -= s;
            seats.remove(0);
            c++;
        }

        return c;
    }

    public static void main(String[] args) {
        int[] P = {4,4,2,4};
        int[] S = {5,5,2,5};
        int result = solution(P, S);
        System.out.println("The minimum number of trips required: " + result);
    }
}
