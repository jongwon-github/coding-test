import java.util.Scanner;

public class Practice0306 {
    public int solution(int n2, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            // 여기가 진짜 중요한 포인트네...
            while (cnt > n2) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n1 = kb.nextInt();
        int n2 = kb.nextInt();
        int[] arr = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n2, arr));
    }
}
