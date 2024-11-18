public class RemoveDuplicatesFromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int count = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }
}
