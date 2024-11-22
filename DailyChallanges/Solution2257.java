public class Solution2257 {
    static int counter = 0;

    public static boolean checkMove(char[][] matrix, int nextX, int nextY) {
        if (nextX >= 0 && nextY >= 0 && nextX < matrix.length && nextY < matrix[nextX].length) {
            if (matrix[nextX][nextY] != 'w' && matrix[nextX][nextY] != 'g') {
                if(matrix[nextX][nextY] != 'o'){
                    matrix[nextX][nextY] = 'o';
                    counter++;
                }
                return true;
            }
        }
        return false;
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        counter = 0;

        char[][] matrix = new char[m][n];

        int guardsCount = 0;
        int wallsCount = 0;

        for (int[] e : guards) {
            matrix[e[0]][e[1]] = 'g';
            guardsCount++;
        }

        for (int[] e : walls) {
            matrix[e[0]][e[1]] = 'w';
            wallsCount++;
        }

        int spaceLeft = m * n - guardsCount - wallsCount;

        for (int[] e : guards) {
            int x = e[0];
            int y = e[1];

            int temp = y - 1;
            // left (x, y - 1)
            while (true) {
                boolean flag = checkMove(matrix, x, temp);
                if (!flag) {
                    break;
                }
                temp--;
            }

            temp = y + 1;
            // right (x, y + 1)
            while (true) {
                boolean flag = checkMove(matrix, x, temp);
                if (!flag) {
                    break;
                }
                temp++;
            }

            temp = x - 1;
            // up (x - 1, y)
            while (true) {
                boolean flag = checkMove(matrix, temp, y);
                if (!flag) {
                    break;
                }
                temp--;
            }

            temp = x + 1;
            // down (x + 1, y)
            while (true) {
                boolean flag = checkMove(matrix, temp, y);
                if (!flag) {
                    break;
                }
                temp++;
            }
        }

        spaceLeft -= counter;

        return spaceLeft;
    }

    public static void main(String[] args) {

        System.out.println(countUnguarded(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}));
    }
}
