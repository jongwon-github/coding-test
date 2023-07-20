import java.util.Arrays;

public class CdTest0108 {
    public int[] solution(int[] enter, int[] exit) {
        int n = enter.length;
        int[] answer = new int[n];
        int[] enterIdx = new int[n];
        int[] enterT = new int[n];
        int[] exitT = new int[n];

        // 들어온 순서를 '0' 부터 지정하려고 아래 로직을 수행 
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }

        // 인덱스 값이 회의실을 출입하는 사람을 의미
        // value 값이 회의실을 출입하는 사람의 순번을 의미
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i] - 1] = i;
        }

        // enterT, exitT 설정
        // enterT : 회의실을 출입하는 사람의 입실 시간
        // exitT : 회의실을 출입하는 사람의 퇴실 시간
        int cnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[j] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }

        /**
         * 왜 확실하게 만나는 경우를 따지는게 어렵지???
         * 1. 입실시간이 빠르고 퇴실시간이 느린 경우
         * 2. 입실시간이 빠르고 퇴실시간이 빠른 경우
         * 3. 입실시간이 늦고 퇴실시간이 빠른 경우
         * 4. 입실시간이 늦고 퇴실시간이 느린 경우
         * 확실하게 만나는 경우는 위 모든 경우를 따져야 함
         * 따라서 확실하게 만나지 않는 경우를 '부정' 해서 확실하게 만나는 경우를 구함
         */

        // 안만나는 경우
        // 입실시간이 빠르고 퇴실시간이 빠른경우
        // 입실시간이 느리고 퇴실시간이 느린경우
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CdTest0108 T = new CdTest0108();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
