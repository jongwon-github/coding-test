import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Practice0405 {
    /* K번째 큰 수 */
    /*
        중복제거를 위해서 TreeSet을 많이 사용한다는걸 기억해두자!!!
    */
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> Test = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Test.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : Test) {
            cnt++;
            if (cnt == k) return x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0405 T = new Practice0405();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }
}
