import java.util.Arrays;

public class Solution2064 {
    private boolean canDistribute(int n, int[] quantities, int item){
        if(item == 0) return false;
        int store = 0;
        for (int product : quantities){
            store += (product - 1) / item + 1;
            if (store > n) return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDistribute(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
