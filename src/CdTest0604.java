import java.util.*;

public class CdTest0604 {
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> sH;
    int len;

    public String[] solution(String s) {
        String[] answer = {};
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sH = new HashMap<>();
        len = s.length();
        for (char c : s.toCharArray()) {
            sH.put(c, sH.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        char mid = '#'; // 이게 왜 필요하지?
        for (char key : sH.keySet()) {
            if (sH.get(key) % 2 == 1) odd++;
        }
        if (odd > 1) return new String[]{};
        return answer;
    }

    public static void main(String[] args) {
        CdTest0604 T = new CdTest0604();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
