import java.util.Arrays;

public class CdTest0104 {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[][] seats = new int[c][r];
        int x = 0, y = 0, direction = 1, count = 1;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        // k값이 존재하는 좌석수보다 더 큰 수 일 경우는 앉을 수 있는 좌석이 없음
        if (k > c * r) return new int[]{0 ,0};

        while (count < k) {
           int tmpX = x + dx[direction];
           int tmpY = y + dy[direction];
           if (tmpX < 0 || tmpX >= c || tmpY < 0 || tmpY >= r || seats[tmpX][tmpY] != 0) {
               direction = (direction + 1) % 4;
               continue;
           }
           seats[x][y] = count;
           count++;
           x = tmpX;
           y = tmpY;
        }

        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }

    public static void main(String[] args) {
        CdTest0104 T = new CdTest0104();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
