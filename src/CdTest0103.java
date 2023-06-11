public class CdTest0103 {
    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction1 = 0, direction2 = 0; // 현수, 강아지가 이동할 방향
        int x = 0, y = 0; // 현수 위치
        int x1 = 0, y1 = 0; // 강아지 위치
        int time = 10000;
        // 현수와 강아지의 초기 위치 세팅
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (board[i][j] == 3) {
                    x1 = i;
                    y1 = j;
                }
            }
        }
        //System.out.println("철수 : " + x +", " + y);
        //System.out.println("강아지 : " + x1 +", " + y1);
        while (time > 0) {
            answer++;
            int tmpX1 = x + dx[direction1];
            int tmpY1 = y + dy[direction1];
            int tmpX2 = x1 + dx[direction2];
            int tmpY2 = y1 + dy[direction2];
//            if ((tmpX1 < 0 || tmpX1 >= board.length) || (tmpY1 < 0 || tmpY1 >= board.length) || board[tmpX1][tmpY1] == 1) {
//                // 이 부분이 핵심 로직
//                // 0, 1, 2, 3 이 반복 되도록 하는 로직
//                direction1 = (direction1 + 1) % 4;
//            }
            int check1 = check(tmpX1, tmpY1, direction1, board);
            if (check1 == direction1) {
                //System.out.println(answer + "번째 -> tmpX1 : " + tmpX1 + ", tmpY1 : " + tmpY1);
                x = tmpX1;
                y = tmpY1;
            } else {
                //System.out.println(answer + "번째 철수방향전화 : " + direction1 + " => " + check1);
                direction1 = check1;
            }
            int check2 = check(tmpX2, tmpY2, direction2, board);
            if (check2 == direction2) {
                //System.out.println(answer + "번째 -> tmpX2 : " + tmpX2 + ", tmpY2 : " + tmpY2);
                x1 = tmpX2;
                y1 = tmpY2;
            } else {
                //System.out.println(answer + "번째 강아지방향전화 : " + direction2 + " => " + check2);
                direction2 = check2;
            }
            if (x == x1 && y == y1) return answer;
            time--;
        }
        return answer;
    }

    public int check(int x, int y, int direction, int[][] board) {;
        if ((x < 0 || x >= board.length) || (y < 0 || y >= board.length) || board[x][y] == 1) {
            // 이 부분이 핵심 로직
            // 0, 1, 2, 3 이 반복 되도록 하는 로직
            direction = (direction + 1) % 4;
        }
        return direction;
    }

    public static void main(String[] args) {
        CdTest0103 T = new CdTest0103();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
