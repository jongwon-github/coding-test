import java.util.Arrays;

public class CdTest0102 {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;
        int direction = 1; // 12시 : 0, 3시 : 1, 6시 : 2, 9시 : 3
        while (k > 0) {
//            if (board[answer[0]][answer[1]] == 1) {
//
//            } else if (board.length - 1 == answer[0]) {
//
//            } else if (board[0].length - 1 == answer[1]) {
//
//            } else {
//                if (direction == 0) {
//                    answer[0]--;
//                } else if (direction == 1) {
//                    answer[1]++;
//                } else if (direction == 2) {
//                    answer[0]++;
//                } else if (direction == 3) {
//                    answer[1]--;
//                }
//            }
           //  생각해 보니 위와 같이 경우를 나눌 필요가 없음...그냥 90도 회전 시키면 되니까...
            int tmpX = x + dx[direction];
            int tmpY = y + dy[direction];
            if ((tmpX < 0 || tmpX >= board.length) || (tmpY < 0 || tmpY >= board.length) || board[tmpX][tmpY] == 1) {
                // 이 부분이 핵심 로직
                // 0, 1, 2, 3 이 반복 되도록 하는 로직
                direction = (direction + 1) % 4;
            } else {
                x = tmpX;
                y = tmpY;
            }
            k--;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        CdTest0102 T = new CdTest0102();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
