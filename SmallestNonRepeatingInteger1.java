public class SmallestNonRepeatingInteger1 {
    public static int findSmallestNonRepeating(int N) {
        int prevDigit = -1;
        int result = 0;
        int multiplier = 1;
    
        while (N > 0) {
            int digit = N % 10;
            N /= 10;
    
            if (digit == prevDigit) {
                digit = (digit + 1) % 10;
                if (digit == prevDigit) {
                    digit = (digit + 1) % 10;
                }
            }
    
            result += digit * multiplier;
            multiplier *= 10;
            prevDigit = digit;
        }
    
        return result;
    }

    public static int solution(int N) { //100%
        N++;
        int lastDigit = -1;
        int result = N;
        while (true) {
            int current = result;
            lastDigit = -1;
            boolean valid = true;
            while (current > 0) {
                int digit = current % 10;
                if (digit == lastDigit) {
                    valid = false;
                    break;
                }
    
                lastDigit = digit;
                current /= 10;
            }
    
            if (valid) {
                return result;
            }
    
            result++;
        }
    }
    
    
    public static void main(String[] args) {
        int N = 1000000000;
        int result = solution(N);
        System.out.println("Smallest integer greater than " + N + " with no consecutive identical digits: " + result);
    }
    
}
