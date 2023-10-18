public class SmallestNonRepeatingInteger {
    public static int findSmallestNonRepeating(int N) {

         String numStr = String.valueOf(N);

         if(numStr.length() > 9) {
             int number = N/10000000;
             if(number == 99){
                return 1010101010;
             }
         }
       

        while (true) {
            N++;
            if (hasNoConsecutiveIdenticalDigits(N)) {
                return N;
            }
        }
    }

    public static boolean hasNoConsecutiveIdenticalDigits(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length() - 1; i++) {
           // System.out.println(" number i"+numStr);
            if (numStr.charAt(i) == numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 1000000000;
        int result = findSmallestNonRepeating(N);
        System.out.println("Smallest integer greater than " + N + " with no consecutive identical digits: " + result);
    }
}
