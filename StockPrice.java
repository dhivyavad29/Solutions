import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] A1 = {4, 1, 2, 3};
        int[] A2 = {1, 2, 3, 3, 2, 1, 5};

        StockPrice stockPrice = new StockPrice();
        System.out.println(stockPrice.solution(A1));
        System.out.println(stockPrice.solution(A2));
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        long s = 0;
        int v = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {  // Dropped
                s += A[i - 1] - v;
                System.out.println(A[i - 1] + " - " + v + " = " + (A[i - 1] - v) + " = " + s);
                v = A[i];
                s %= 1000000000;
            } else if (i == A.length - 1) {
                System.out.println(A[i] + " - " + v + " = " + (A[i] - v) + " = " + s);
                s += A[i] - v;
                s %= 1000000000;
            }
        }

        return (int) s;
    }
}
