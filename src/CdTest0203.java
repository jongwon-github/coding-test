import java.util.HashMap;
import java.util.HashSet;

public class CdTest0203 {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }
        HashSet<Integer> hSet = new HashSet<>(); // 데이터를 중복 저장할 수 없고 순서를 보장하지 않음
        for (char c : hMap.keySet()) {
            while (hSet.contains(hMap.get(c))) {
                answer++;
                hMap.put(c, hMap.get(c) - 1);
            }
            if (hMap.get(c) == 0) continue;
            hSet.add(hMap.get(c));
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0203 T = new CdTest0203();
        System.out.println(T.solution("aebbbc"));
    }
}
