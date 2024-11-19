import java.util.*;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {
//        Deque<Integer> queue = new LinkedList<>();
//        Arrays.stream(nums).forEach(queue::add);
//
//        for (int i = 0; i < k; i++){
//            int temp = queue.removeLast();
//            queue.addFirst(temp);
//        }
//
//        for (int i = 0; i < nums.length; i++){
//            nums[i] = queue.pop();
//        }

//        int n = nums.length;
//        k = k % n;
//
//        int[] rotated = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            rotated[(i + k) % n] = nums[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = rotated[i];
//        }

        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1); // reverse the array
        reverse(nums, 0, k - 1); // reverse the first k elements
        reverse(nums, k, n - 1); // reverse the last n-k elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}
