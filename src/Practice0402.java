import java.util.HashMap;
import java.util.Scanner;

public class Practice0402 {
    public String solution(String str1, String str2) {
        /*String answer = "YES";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        HashMap<Character, Integer> hMap1 = new HashMap<>();
        HashMap<Character, Integer> hMap2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            hMap1.put(arr1[i], hMap1.getOrDefault(arr1[i], 0) + 1);
            hMap2.put(arr2[i], hMap2.getOrDefault(arr2[i], 0) + 1);
        }
        boolean flag = true;
        for (char key : hMap1.keySet()) {
            if (!hMap2.containsKey(key) || hMap1.get(key) != hMap2.get(key)) {
                answer = "NO";
                break;
            }
        }
        return answer;*/
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Practice0402 T = new Practice0402();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.nextLine();
        String str2 = kb.nextLine();
        System.out.println(T.solution(str1, str2));
    }
}