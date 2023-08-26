import java.util.ArrayList;
import java.util.Arrays;

public class CdTest0605 {
    ArrayList<String> arList = new ArrayList<>();

    public boolean check(String component) {
        boolean flag = true;
        if (component.length() > 2) {
            if (component.startsWith("0") || Integer.parseInt(component) > 255) flag = false;
        }
        return flag;
    }

    public void DFS(int L, int start, String s) {
        if (start >= s.length() - 1) return;
        if (L == 4) {
            String tmp = "";
            for (String str : arList) {
                tmp += str;
            }
            if (tmp.length() == s.length()) {
                System.out.println(tmp);
                System.out.println();
            }
            arList = new ArrayList<>();
        } else {
            for (int i = start; i < s.length() - 2; i++) {
                String component = s.substring(start, i + 1);
                if (check(component)) {
                    arList.add(component);
                    DFS(L + 1, i + 1, s);
                }
            }
        }
    }

    public String[] solution(String s) {
        String[] answer = {};
        DFS(0, 0, s);
        return answer;
    }

    public static void main(String[] args) {
        CdTest0605 T = new CdTest0605();
        System.out.println(Arrays.toString(T.solution("2025505")));
//        System.out.println(Arrays.toString(T.solution("0000")));
//        System.out.println(Arrays.toString(T.solution("255003")));
//        System.out.println(Arrays.toString(T.solution("155032012")));
//        System.out.println(Arrays.toString(T.solution("02325123")));
//        System.out.println(Arrays.toString(T.solution("121431211")));
//        String test = "abc";
//        System.out.println(test.substring(2, 0));
    }
}
