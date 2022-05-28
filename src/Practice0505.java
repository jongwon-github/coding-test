import java.util.Scanner;
import java.util.Stack;

public class Practice0505 {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0505 T = new Practice0505();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
