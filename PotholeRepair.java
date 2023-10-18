public class PotholeRepair {
    public static int maxPotholesRepaired(String lane1, String lane2) {
        int n = lane1.length();
        int maxRepairs = 0;

        for (int i = 0; i < n; i++) {
            if (lane1.charAt(i) == 'x' || lane2.charAt(i) == 'x') {
                int repairs = 0;
                while (i < n && (lane1.charAt(i) == 'x' || lane2.charAt(i) == 'x')) {
                    repairs++;
                    i++;
                }
                maxRepairs = Math.max(maxRepairs, repairs);
            }
        }

        return maxRepairs;
    }

    public static void main(String[] args) {
        String lane1 = "x...x";
        String lane2 = "..x..";
        int repairs = maxPotholesRepaired(lane1, lane2);
        System.out.println("Maximum potholes repaired: " + repairs);

        lane1 = "xxxxx";
        lane2 = ".x..x";
        repairs = maxPotholesRepaired(lane1, lane2);
        System.out.println("Maximum potholes repaired: " + repairs);

        lane1 = ".xxx...x";
        lane2 = "..x.xxxx";
        repairs = maxPotholesRepaired(lane1, lane2);
        System.out.println("Maximum potholes repaired: " + repairs);
    }
}
