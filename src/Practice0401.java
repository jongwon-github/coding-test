import java.util.HashMap;
import java.util.Scanner;

public class Practice0401 {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }
        int maxValue = Integer.MIN_VALUE;
        for (char key : hMap.keySet()) {
            if (maxValue < hMap.get(key)) {
                maxValue = hMap.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Practice0401 T = new Practice0401();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}
