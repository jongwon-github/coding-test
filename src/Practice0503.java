import java.util.Scanner;
import java.util.Stack;

public class Practice0503 {
    /* stack의 최 상위 값을 stack.get(stack.size() - 1) 이렇게도 가져올 수 있지만 'peek' 메소드를 통해서도 가져올 수 있음 */
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                int tmp = board[i][pos - 1];
                if (tmp != 0) {
                    if (!stack.isEmpty() && stack.get(stack.size() - 1) == tmp) {
                        stack.pop();
                        answer += 2;
                    } else stack.push(tmp);
                    board[i][pos - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0503 T = new Practice0503();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) moves[i] = kb.nextInt();
        System.out.println(T.solution(board, moves));
    }
}
