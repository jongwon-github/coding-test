import java.util.Scanner;

/* 버블정렬 : 정렬 과정에서 원소의 이동이 마치 거품이 수면위로 올라오는 것 같다고 해서 거품(Bubble) 이라는 이름이 붙었다고 함 */
public class Practice0602 {
    public int[] solution(int n, int[] arr) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Practice0602 T = new Practice0602();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
