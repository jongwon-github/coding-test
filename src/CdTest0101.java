import java.util.Arrays;

public class CdTest0101 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        answer[0] = 'A';
        for (int i = 1; i < n; i++) {
            answer[i] = (char) (answer[i - 1] + 1);
        }
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                int num = ladder[i][j];
                char tmp = answer[num - 1];
                answer[num - 1] = answer[num];
                answer[num] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0101 T = new CdTest0101();
        //T.solution(5, new int[5][5]);
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
