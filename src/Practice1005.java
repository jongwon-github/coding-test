import java.util.Arrays;
import java.util.Scanner;

public class Practice1005 {
    static int[] dy;

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        /*
            동전 종류별로 반복문(동전 금액을 시작점으로 함)을 돌면서 인덱스 값만큼의 금액을 거슬러 줄 동전 수를 dy 배열에 할당
            dy[j - coin[i]] + 1 : 해당 동전을 사용해 거슬러 줄 최소 동전의 갯수
         */
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= dy.length - 1; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[dy.length - 1];
    }

    public static void main(String[] args) {
        Practice1005 T = new Practice1005();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        /*
            동적 배열의 크기는 입력 받은 거슬러 줄 '금액 + 1' 로 설정
            동적 배열의 인덱스값을 거슬러 줄 금액으로 설정하기 위함
        */
        dy = new int[m + 1];
        System.out.println(T.solution(arr));
    }
}
