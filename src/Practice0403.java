import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Practice0403 {
    public ArrayList<Integer> solution(int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
        }
        int left = 0;
        for (int right = k - 1; right < arr.length; right++) {
            hMap.put(arr[right], hMap.getOrDefault(arr[right], 0) + 1);
            answer.add(hMap.size());
            hMap.put(arr[left], hMap.getOrDefault(arr[left], 0) - 1);
            if (hMap.get(arr[left]) == 0) hMap.remove(arr[left]);
            left++;
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
