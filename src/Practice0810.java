import java.util.*;

public class Practice0810 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && ny > 0) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        DFS(nx, ny);
                        board[nx][ny] = 0;
                    }
                }
            }   
        }
    }

    public static void main(String[] args) {
        Practice0810 T = new Practice0810();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        // 여기에 왜 1을 넣지???
        board[1][1] = 1;
        T.DFS(1, 1);
        System.out.println(answer);
    }
}
