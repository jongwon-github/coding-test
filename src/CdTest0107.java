public class CdTest0107 {
    int[][] board = new int[3][3];

    public int[] getPos(int val) {
        int[] pos = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == val) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    public int solution(int[] keypad, String password){
        int answer = 0, row = 0, col = 0, posX = 0, posY = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};

        // 2행 2열 배열로 만들까???
        for (int i = 0; i < keypad.length; i++) {
            if (i != 0 && i % 3 == 0) {
                row++;
                col = 0;
            }
            // 최초 시작점 설정
            if (keypad[i] == Integer.parseInt(String.valueOf(password.charAt(0)))) {
                posX = row;
                posY = col;
            }
            board[row][col++] = keypad[i];
        }

        int cnt = 1;
        while (password.length() > cnt) {
            int val = Integer.parseInt(String.valueOf(password.charAt(cnt)));
            int[] pos = getPos(val);
            if (!(posX == pos[0] && posY == pos[1])) {
                boolean findFlag = false;
                for (int i = 0; i < 8; i++) {
                    int nPosX = posX + dx[i];
                    int nPosY = posY + dy[i];
                    if (nPosX >= 0 && nPosX < board.length && nPosY >= 0 && nPosY < board.length) {
                        if (board[nPosX][nPosY] == val) {
                            findFlag = true;
                            break;
                        }
                    }
                }
                if (findFlag) answer++;
                else answer += 2;
            }
            posX = pos[0];
            posY = pos[1];
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CdTest0107 T = new CdTest0107();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
