import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Practice0403 {
    public ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int left = 0, right = num;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        while (right <= arr.length) {
           for (int i = left; i < right; i++) {
               hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
           }
            System.out.println(hMap);
           answer.add(hMap.size());
           hMap.remove(arr[left++]);
           right++;
        }
        return answer;
    }

    public static void main(String[] args){
        Practice0403 T = new Practice0403();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (Integer item : T.solution(k, arr)) {
            System.out.print(item + " ");
        }
    }
}
