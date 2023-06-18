import java.util.ArrayList;
import java.util.List;

public class CdTest0105 {
    public int solution(int[] nums){
        int answer = 0;
        List<Integer> peaks = new ArrayList<>();

        // 봉우리가 될 수 있는 숫자의 인덱스 번호를 peaks 리스트로 재정의
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) peaks.add(i);
        }

        for (int n : peaks) {
            int left = n;
            int right = n;
            int cnt = 1;

            // 봉우리를 중심으로 왼쪽으로 감소하는 길이를 구함
            while (left > 0) {
                if (nums[left] > nums[left - 1]) cnt++;
                else break;
                left--;
            }
            // 봉우리를 중심으로 오른쪽으로 감소하는 길이를 구함
            while (right < nums.length - 1) {
                if (nums[right] > nums[right + 1]) cnt++;
                else break;
                right++;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 바이토닉 수열이란 수열이 증가했다가 감소하는 수열을 의미
        CdTest0105 T = new CdTest0105();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
