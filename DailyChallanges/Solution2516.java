public class Solution2516 {
    public int takeCharacters(String s, int k) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int n = s.length();

        int l = 0;
        int r = 0;
        int ans = n;

        int totalA = 0, totalB = 0, totalC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') totalA++;
            else if (ch == 'b') totalB++;
            else totalC++;
        }

        if (totalA < k || totalB < k || totalC < k) {
            return -1;
        }

        while (r < n) {
            if (s.charAt(r) == 'a') aCount++;
            if (s.charAt(r) == 'b') bCount++;
            if (s.charAt(r) == 'c') cCount++;
            r++;

            while (aCount > totalA - k || bCount > totalB - k || cCount > totalC - k) {
                if (s.charAt(l) == 'a') aCount--;
                if (s.charAt(l) == 'b') bCount--;
                if (s.charAt(l) == 'c') cCount--;
                l++;
            }

            ans = Math.min(ans, n - (r - l));
        }
        return ans;
    }
}
