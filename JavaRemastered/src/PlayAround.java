import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class PlayAround {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int[][] matrix, int i, int j) {
        int n = matrix.length, m = matrix[0].length;
        if (matrix[i][j] == -1) return;
        matrix[i][j] = -1;
        int area = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] == -1 || matrix[x][y] == 0) continue;
            dfs(matrix, x, y);
        }
        return;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };

        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> areas = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // cnt = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    cnt++;
                    areas.add(cnt);
                }
            }
        }
        System.out.println(cnt);

    }

}
// vis - n X m, matrix
// initially all will be true
//
// 1-> needs to be traversed
// 0,2->vis
//
// int cnt = 0;
// cnt = 2;
//
// ArrayList<Integer> area = new ArrayList<>;
// int temparea = 0;// pass while using dfs
// temparea++;
//
// 0,0,1,1
// 1,1,0,0
// 0,1,0,0
//
// 0,0,1,1
// 1,1,0,0
// 0,1,0,0

