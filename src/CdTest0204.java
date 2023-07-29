import java.util.HashMap;

public class CdTest0204 {
    public int solution(int[] nums, int m) {
        int sum = 0,  answer = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        hMap.put(0, 1); // sum값이 5가되는 경우 answer에 누적시키기 위한 초기값 설정
        /**
         * 1. 배열을 반복하면서 sum에 각 인덱값을 더해줌
         * 2. sum에서 찾고자하는 특정값 m을 뺀 값이 hMap에 key로 존재하는지 체크
         * (sum - m)값이 key값으로 존재한다는 의미는 배열에 i번째 인덱스까지 부분수열의 합중, m값이 될 경우의 수가 hMap.get(sum - m) 만큼 존재한다는 의미
         * 3. 존재한다면 해당값을 key로 하는 value값을 answer에 누적
         * 4. sum값을 hMap으로 해싱
         */
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int chkVal = sum - m;
            if (hMap.containsKey(chkVal)) answer += hMap.get(chkVal);
            hMap.put(sum, hMap.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0204 T = new CdTest0204();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
