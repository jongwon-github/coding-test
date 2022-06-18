import java.util.Arrays;
import java.util.Scanner;

public class Practice0609 {
    public int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        /*for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > capacity) {
                cnt++;
                sum = arr[i];
            }
        }*/
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        // 1. 노래를 담을 수 있는 cd의 최소용량과 최대용량을 설정
        // 2. 최소용량은 배열에 담기 마직막 노래의 용량(노래의 용량값이 오름차순으로 정리되어 있기 때문)
        // 3. 최대용량은 배열에 담긴 모든 노래 용량의 합
        // 4. 최소용량과 최대용량을 이용해 결정알고리즘으로 정답을 구함
        int answer = 0, lt = 0, rt = 0;
        lt = Arrays.stream(arr).max().getAsInt();
        rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                rt = mid - 1;
                answer = mid;
            } else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0609 T = new Practice0609();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}