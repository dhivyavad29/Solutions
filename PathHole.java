public class PathHole {
    public static void main(String[] args) {
        String L1 = "..xx.x.";
        String L2 = "x.x.x..";
        System.out.println(Math.max(solution(L1, L2), solution(L2, L1)));
    }

    private static int solution(String L1, String L2) {
        int n = L1.length();
        int[] r = new int[n];
        int[] l = new int[n];
        int c = 0;
        
        for (int i = 0; i < n; i++) {
            c += L2.charAt(i) == 'x' ? 1 : 0;
            l[i] = c;
        }
        
        c = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            c += L1.charAt(i) == 'x' ? 1 : 0;
            r[i] = c;
        }
        
        int max = r[0];
        
        for (int i = 1; i < n - 1; i++) {
            int a = l[i - 1];
            int b = r[i + 1];
            max = Math.max(max, a + b);
        }
        
        max = Math.max(max, l[l.length - 1]);
        
        return max;
    }
    
}
