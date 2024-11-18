import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.merge(nums[i], 1, Integer::sum);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        return map.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}
