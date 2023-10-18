public class MinMovesToNoConsecutiveThree {

    public static int minMovesToNoConsecutiveThree(String input) {
        int moves = 0;
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count == 3) {
                moves++;
                count = 0;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        String input = "AAABBBCCCAAABBB";
        int moves = minMovesToNoConsecutiveThree(input);
        System.out.println("Minimum moves to remove consecutive threes: " + moves);
    }
}
