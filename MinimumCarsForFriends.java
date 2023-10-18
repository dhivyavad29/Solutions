import java.util.Arrays;

public class MinimumCarsForFriends {

    public static void main(String[] args) {
        int[] P = {2,3,4,2};
        int[] S = {2,5,7,2};
        
        int result = solution(P, S);
        System.out.println("Minimum number of passes: " + result);
    }

    public static int solution(int[] P, int[] S) {
        int totalPerson = Arrays.stream(P).sum();
        int carsNeeded = 0;
        Arrays.sort(S);
        for (int i = S.length - 1; i >= 0; i--) {
            if (totalPerson - S[i] > 0) {
                totalPerson -= S[i];
                carsNeeded++;
            } else {
                carsNeeded++;
                return carsNeeded;
            }
        }
        return carsNeeded;
    }
}