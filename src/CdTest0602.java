import java.util.Stack;

public class CdTest0602 {
    int answer = 0;
    int[] chk;
    int[][] relation;
    Stack<Integer> pm;

    public void DFS(int L) {
        if (L == 7) {
            answer++;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (chk[i] == 0) {
                    /*if (!pm.empty()) {
                        int prevNum = pm.peek();
                        if (relation[prevNum][i] == 1) continue;
                    }*/
                    /**
                     * 줄다리기를 위해 학생들을 일렬로 세우는 정보는 Stack에 기록
                     * 재귀함수가 완료된 뒤, 학생 정보를 제외해야 하는데 Stack의 pop 메소드로 간단히 해결할 수 있음
                     * 처음에는 chk 배열같이 배열 정보를 하나 더 생성해서 학생들을 일렬로 세우는 정보를 저장해야 하나 생각 했었음
                     */
                    if (!pm.empty() && relation[pm.peek()][i] == 1) continue;
                    chk[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    chk[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight) {
        answer = 0;
        chk = new int[8];
        relation = new int[8][8];
        pm = new Stack<>();
        /**
         * 서로 싫어하는 정보(fight)가 주어지면 서로 싫어하는 학생끼리 이웃하지 않게 줄을 세워야 함
         * relation 2차원 배열에 서로 싫어하는 학생들의 정보를 기록
         */
        for (int[] notFriendly : fight) {
            relation[notFriendly[0]][notFriendly[1]] = 1;
            relation[notFriendly[1]][notFriendly[0]] = 1;
        }
        DFS(0);
        return answer;
    }

    public static void main(String[] args) {
        CdTest0602 T  = new CdTest0602();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
