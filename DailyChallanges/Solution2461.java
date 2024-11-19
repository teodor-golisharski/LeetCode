import java.util.HashMap;
import java.util.Map;


public class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> um = new HashMap<>();
        int l = 0, r;
        long lastSum = 0;

        for (r = 0; r < k; r++) {
            um.put(nums[r], um.getOrDefault(nums[r], 0) + 1);
            lastSum += nums[r];
        }

        long sum = 0;
        while (r <= nums.length) {
            if (um.size() == k) { // Check if window is distinct
                sum = Math.max(lastSum, sum);
            }

            if (l < nums.length) {
                um.put(nums[l], um.get(nums[l]) - 1);
                if (um.get(nums[l]) == 0) {
                    um.remove(nums[l]);
                }
                lastSum -= nums[l];
                l++;
            }

            if (r < nums.length) {
                um.put(nums[r], um.getOrDefault(nums[r], 0) + 1);
                lastSum += nums[r];
            }
            r++;
        }

        return sum;
    }
}
