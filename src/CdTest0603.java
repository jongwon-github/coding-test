import java.util.ArrayList;

public class CdTest0603 {
    int answer, n;
    int[] chk;

    /**
     * 총 인원수(n) 중 흰돌 n / 2, 검은돌 n / 2 가 되어야 함
     * chk 배열에 값이 1인 경우 흰돌, 1이 아닌 경우 검은돌
     * s를 사용해 흰돌로 출전하는 선수가 n / 2 가 되는 조합수를 기준으로 흰돌과 검은돌의 능력치 차이 계산
     */
    public void DFS(int L, int s, int[][] cans) {
        if (L == n / 2) {
            ArrayList<Integer> white = new ArrayList<>();
            ArrayList<Integer> black = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (chk[i] == 1) white.add(cans[i][0]);
                else black.add(cans[i][1]);
            }
            answer = Math.min(answer, Math.abs(white.stream().reduce(0, (a, b) -> a + b) - black.stream().reduce(0, (a, b) -> a + b)));
        } else {
            for (int i = s; i < n; i++) {
                if (chk[i] == 0) {
                    chk[i] = 1;
                    DFS(L + 1, i + 1, cans);
                    chk[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        n = cans.length;
        chk = new int[cans.length];
        DFS(0, 0, cans);
        return answer;
    }

    public static void main(String[] args) {
        CdTest0603 T = new CdTest0603();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
