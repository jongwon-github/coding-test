import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CdTest0605 {
    LinkedList<String> tmp;
    ArrayList<String> res;

    public void DFS(int L, int start, String s) {
        if (L == 4 && start == s.length()) {
            String Ts = "";
            for(String x : tmp) Ts += x + ".";
            res.add(Ts.substring(0, Ts.length()-1));
        } else {
            for (int i = start; i < s.length(); i++) {
                // '0'으로 시작하면서 길이가 2 이상인 경우 return
                if (s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                // num 이 255 보다 큰 경우 return
                if (Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(L + 1, i + 1, s);
                // 호출한 재귀함수가 종료 되었을 때, tmp 마지막 요소 제거
                tmp.remove(L);
            }
        }
    }

    /**
     * 풀이에 나와있는 답
     * int L 변수는 사용하지 않음
     */
//    public void DFS(int start, String s){
//        if(tmp.size() == 4 && start == s.length()){
//            String Ts = "";
//            for(String x : tmp) Ts += x + ".";
//            res.add(Ts.substring(0, Ts.length()-1));
//        }
//        else{
//            for(int i = start; i < s.length(); i++){
//                if(s.charAt(start) == '0' && i > start) return;
//                String num = s.substring(start, i + 1);
//                if(Integer.parseInt(num) > 255) return;
//                tmp.add(num);
//                DFS(i + 1, s);
//                tmp.pollLast();
//            }
//        }
//    }

    public String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, 0, s);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args) {
        CdTest0605 T = new CdTest0605();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
