import java.util.*;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        Arrays.stream(nums).forEach(queue::add);

        for (int i = 0; i < k; i++){
            int temp = queue.removeLast();
            queue.addFirst(temp);
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = queue.pop();
        }
    }
}
