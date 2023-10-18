import java.util.Arrays;

public class DivideArrayIntoThreeGroups {
    public static int minMaxDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        if (n < 3) {
            return 0; // Not enough elements to form three groups.
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int group1Max = Arrays.stream(Arrays.copyOfRange(nums, 0, i)).max().getAsInt();
            int group1Min = Arrays.stream(Arrays.copyOfRange(nums, 0, i)).min().getAsInt();
            for (int j = i + 1; j < n; j++) {
                int group2Max = Arrays.stream(Arrays.copyOfRange(nums, i, j)).max().getAsInt();
                int group2Min = Arrays.stream(Arrays.copyOfRange(nums, i, j)).min().getAsInt();
                int group3Max = Arrays.stream(Arrays.copyOfRange(nums, j, n)).max().getAsInt();
                int group3Min = Arrays.stream(Arrays.copyOfRange(nums, j, n)).min().getAsInt();
                
                int maxDifference = Math.max(group1Max - group1Min, Math.max(group2Max - group2Min, group3Max - group3Min));
                result = Math.min(result, maxDifference);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 19, 20};
        int result = minMaxDifference(nums);
        System.out.println("Minimum maximum difference: " + result);
    }
}
