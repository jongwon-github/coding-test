import java.util.*;

public class CdTest0201 {
    public int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // getOrDefault : 해당 키값으로 하는 value 가 존재한다면 그 값을 가지고 오고 아니면 defaultValue 값을 return
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i + 1;
        }
       return -1;
    }

    public static void main(String[] args) {
        CdTest0201 T = new CdTest0201();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    }
}
