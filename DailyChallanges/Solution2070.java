import java.util.*;

public class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a,b) -> Integer.compare(a[0], b[0]));

        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i< queries.length; i++){
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));
        List<int[]> maxBeautyAtPrice = new ArrayList<>();
        int currentMaxBeauty = 0;

        for (int[] item : items){
            int price = item[0];
            int beauty = item[1];
            currentMaxBeauty = Math.max(currentMaxBeauty, beauty);
            maxBeautyAtPrice.add(new int[]{price, currentMaxBeauty});
        }


        int[] result = new int[queries.length];
        int i = 0;

        for (int[] query : queriesWithIndex) {
            int queryPrice = query[0];
            int originalIndex = query[1];

            while (i < maxBeautyAtPrice.size() && maxBeautyAtPrice.get(i)[0] <= queryPrice) {
                i++;
            }

            result[originalIndex] = (i > 0) ? maxBeautyAtPrice.get(i - 1)[1] : 0;
        }

        return result;
    }
}
