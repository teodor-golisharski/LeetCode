import java.util.*;

public class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {

            int temp = queries[i];
            if (map.containsKey(temp)) {
                result[i] = map.get(temp);
            } else {
                int max = Arrays.stream(items)
                        .filter(item -> item[0] <= temp)
                        .mapToInt(item -> item[1])
                        .max()
                        .orElse(0);

                result[i] = max;
                map.put(queries[i], max);
            }
        }
        return result;
    }
}
