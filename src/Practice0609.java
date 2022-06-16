import java.util.Arrays;
import java.util.Scanner;

public class Practice0609 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0, rt = 0;
        // 1. 노래를 담을 수 있는 cd의 최소용량과 최대용량을 설정
        // 2. 최소용량은 배열에 담기 마직막 노래의 용량(노래의 용량값이 오름차순으로 정리되어 있기 때문)
        lt = arr[n - 1];
        for (int i = 0; i < n; i++) {
            rt += arr[i];
        }
        while (lt <= rt) {
            int hap = 0;
            int cnt = 0;
            int mid = (lt + rt) / 2;
            for (int i = 0; i < n - 1; i++) {
                hap += arr[i];
                if (hap > mid) {
                    cnt++;
                    hap = arr[i];
                }  
            }
            if (cnt <= 3) rt = mid;
            else lt = mid;
        }
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