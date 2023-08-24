import java.util.Scanner;

public class Real0810 {
    int[] x = {0, 1, 0, -1}, y ={-1, 0, 1, 0};
    static int[][] board = new int[7][7];
    static int answer = 0;

    public void DFS(int L, int x, int y) {
        if (x < 0 || x > 6) return;
        if (board[x][y] == 1) return;
        if (L == 7 && x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {

            }
        }
    }

    public static void main(String[] args) {
        Real0810 T = new Real0810();
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        T.DFS(0, 0, 0);
    }
}
