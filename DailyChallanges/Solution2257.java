import java.util.HashSet;
import java.util.Set;

public class Solution2257 {

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> guardSet = new HashSet<>();
        Set<String> wallSet = new HashSet<>();
        Set<String> guardedSet = new HashSet<>();

        for (int[] e : guards) {
            guardSet.add(e[0] + "," + e[1]);
        }

        for (int[] e : walls) {
            wallSet.add(e[0] + "," + e[1]);
        }

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int spaceLeft = m * n;

        for (int[] e : guards) {
            int x = e[0];
            int y = e[1];

            for (int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                while (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    String pos = nextX + "," + nextY;

                    if (guardSet.contains(pos) || wallSet.contains(pos)) {
                        break;
                    }

                    guardedSet.add(pos);

                    nextX += dir[0];
                    nextY += dir[1];
                }
            }
        }

        spaceLeft -= (guardedSet.size() + wallSet.size() + guardSet.size());

        return spaceLeft;
    }

    public static void main(String[] args) {

        System.out.println(countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
        //System.out.println(countUnguarded(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}));
    }
}
