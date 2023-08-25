import java.util.*;

public class CdTest0604 {
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> sH;
    int len;

    public void DFS() {
        if (tmp.size() == len) {
            String str = "";
            for (char c : tmp) str += c;
            res.add(str);
        } else {
            for (char c : sH.keySet()) {
                if (sH.get(c) != 0) {
                    tmp.addFirst(c);
                    tmp.addLast(c);
                    sH.put(c, sH.get(c) - 2);
                    DFS();
                    tmp.pollFirst();
                    tmp.pollLast();
                    sH.put(c, sH.get(c) + 2);
                }
            }
        }
    }

    public String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sH = new HashMap<>();
        len = s.length();
        for (char c : s.toCharArray()) {
            sH.put(c, sH.getOrDefault(c, 0) + 1);
        }
        int odd = 0; // 홀수로 사용되는 문자가 > 1 이면 팰린드롬이 될 수 없음
        char mid = '#'; // 팰린드롬의 중간 문자로 사용하기 위해 선언된 변수(※ 홀수로 사용되는 문자)
        for (char key : sH.keySet()) {
            if (sH.get(key) % 2 == 1) {
                odd++;
                mid = key;
            }
        }
        if (odd > 1) return new String[]{};
        // 홀수인 문자가 존재할 경우, 해당 문자 하나는 팰린드롬의 중간에 배치하면 짝수인 문자들만 존재
        // 짝수 문자들을 DFS를 통해 돌아가면서 중간 문자 좌우로 배치하면 팰린드롬 완성
        if (mid != '#') {
            tmp.add(mid);
            sH.put(mid, sH.get(mid) - 1);
        }
        DFS();
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
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
