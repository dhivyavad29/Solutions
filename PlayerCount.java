import java.util.Arrays;

public class PlayerCount {
    

    public static int solution(String S) {
        int n = S.length();
        int s = 0;
        boolean[] isOccupied = new boolean[n];
        Arrays.fill(isOccupied, true);

        for (int i = 0; i < n; i++) {
            char move = S.charAt(i);
            int target = i;

            if (move == '<') {
                if (i == 0 || !isOccupied[i - 1]) {
                    s++;
                    isOccupied[i] = false;
                }
            } else if (move == '^' || move == 'v') {
                s++;
                isOccupied[i] = false;
            } else if (i == n - 1) {
                s++;
            }
            System.out.println(move + " " + s);
        }
        return s;
    }
    public static void main(String[] args) {
        String S1 = "><^v";
        int result = solution(S1);
        System.out.println("Result: " + result);
    }
}
