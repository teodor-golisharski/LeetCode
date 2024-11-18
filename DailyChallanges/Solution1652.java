import java.util.LinkedList;

public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) return res;

        int sum = 0;
        int start = (k > 0) ? 1 : n + k;
        int end = (k > 0) ? k : n - 1;

        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[(start + i) % n];
            sum += code[(end + i + 1) % n];
        }

        return res;
    }
}
