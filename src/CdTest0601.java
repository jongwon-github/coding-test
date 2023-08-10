import java.util.ArrayList;

public class CdTest0601 {
    ArrayList<Integer> nums;
    int[] chk;
    int m, target, answer; // target의 용도는 멀까??? -> 단순히 입력 받은 숫자(n)를 전역적으로 사용하기 위한 변수
    boolean flag = false;

    public void DFS(int L, int number) {
        if (flag) return;
        if (L == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (chk[i] == 0) {
                    chk[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    chk[i] = 0;
                }
            }
        }
    }

    public int solution(int n) {
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        // 이걸 굳이 왜 해주는거지???
        // 입력받은 숫자(n)의 각 자리수를 분리하고 오름차순으로 정렬한 뒤, DFS를 호출하면
        // 입력받은 숫자(n)로 구성 할 수 있는 가장 작은 수부터 탐색이 가능하고 탐색을 진행하다가
        // target 보다 처음으로 커지는 수가 가장 가까운 큰수로 판단
        nums.sort((a, b) -> a.compareTo(b));
        chk = new int[nums.size()];
        m = nums.size();
        target = n;
        DFS(0, 0);
        if (!flag) return -1;
        return answer;
    }

    public static void main(String[] args) {
        CdTest0601 T = new CdTest0601();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
