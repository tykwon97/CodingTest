package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static class Spot {
        int x;
        int y;

        Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        int height = Integer.MIN_VALUE;

        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (height < map[i][j]) {
                    height = map[i][j];
                }
            }
        }

        int answer = 1;
        for (int rain = 1; rain < height; rain++) {

            int safeSpot = 0;
            for (int i = 1; i <= n; i++) {
                Arrays.fill(isVisited[i], false);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i]g[j] > rain && !isVisited[i][j]) {
                        isSafe(rain, i, j);
                        safeSpot++;
                    }
                }
            }
            if (answer < safeSpot) {
                answer = safeSpot;
            }
        }

        System.out.println(answer);
    }

    private static void isSafe(int rain, int i, int j) {
        Queue<Spot> spots = new LinkedList<>();
        spots.add(new Spot(i, j));

        while (!spots.isEmpty()) {
            Spot spot = spots.poll();

            int x = spot.x;
            int y = spot.y;

            if (isVisited[x][y]) {
                continue;
            }

            isVisited[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (1 <= nx && nx <= n && 1 <= ny && ny <= n) {
                    if (map[nx][ny] > rain && !isVisited[nx][ny]) {
                        spots.add(new Spot(nx, ny));
                    }
                }
            }
        }
    }
}
