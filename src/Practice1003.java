import java.util.Scanner;

public class Practice1003 {
    // 해당 배열값에는 동일한 인덱스의 arr 배열값을 끝으로하는 부분증가수열값이 들어감
    static int[] dy;

    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                // 현재 배열(arr[i])의 값이 이전 배열(arr[j])값보다 작다면 로직 실행 불필요 : 부분증가수열은 arr[i]값이 최대인 부분증가수열값을 구해야 하기 때문에 자신보다 큰값은 제외를 시켜야 함
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice1003 T = new Practice1003();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
