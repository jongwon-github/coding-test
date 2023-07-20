import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CdTest0202 {
    public int[] solution(String s) {
        int[] answer = new int[5];
        char[] charArr = {'a', 'b', 'c', 'd', 'e'};
        Map<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for (Character c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0) + 1;
            maxCnt = Math.max(maxCnt, cnt);
            map.put(c, cnt);
        }
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsKey(charArr[i])) answer[i] = maxCnt - map.get(charArr[i]);
            else answer[i] = maxCnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0202 T = new CdTest0202();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        for (int n : T.solution(s)) {
            System.out.print(n + " ");
        }
    }
}
