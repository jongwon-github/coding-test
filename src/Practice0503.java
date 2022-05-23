import java.util.Scanner;
import java.util.Stack;

public class Practice0503 {
    public int solution(int n, int[][] arr1, int[] arr2) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[j][arr2[i] - 1] != 0) {
                    if (stack.get(stack.size() - 1) == arr1[j][arr2[i] - 1]) {
                        stack.pop();
                    } else {
                        stack.push(arr1[j][arr2[i] - 1]);
                    }
                    arr1[j][arr2[i] - 1] = 0;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0503 T = new Practice0503();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
