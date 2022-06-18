import java.util.Arrays;
import java.util.Scanner;

public class Practice0610 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 두 말의 거리값 중 최소값 -> 이건 최대값과 다르게 arr[0]으로 세팅하면 안됨
        // ex) 5, 8, 9, 10, 11 일 경우 거리의 최대값은 8 - 5 = 3 인데 arr[0]으로 세팅되면 안됨
        int lt = arr[1] - arr[0];
        // 두 말의 거리값 중 최대값 -> (arr[n - 1] - arr[0]) 값이 정확할 거 같은데 어차피 이분검색으로 값을 줄여 나날거라 마구간 위치 정보 중 제일 큰 값으로 세팅
        int rt = arr[n - 1];
        while (lt <= rt) {
            // 이전 마구간의 위치 정보
            int ep = arr[0];
            int mid = (lt + rt) / 2;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (arr[i] - ep >= mid) {
                    ep = arr[i];
                    cnt++;
                }
            }
            if (cnt < m) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }
        System.out.println("anser : " + answer);
        return answer;
    }

    public static void main(String[] args) {
        Practice0610 T = new Practice0610();
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
