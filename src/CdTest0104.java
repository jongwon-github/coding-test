import java.util.Arrays;

public class CdTest0104 {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[][] seats = new int[c][r];
        int[] dx = {}, dy = {};
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
