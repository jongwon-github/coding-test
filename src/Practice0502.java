import java.util.Scanner;
import java.util.Stack;

public class Practice0502 {
    /*
    * stack의 pop은 제거와 동시에 제거된 객체(제네릭으로 선언 되어진 객체) return
    * stack의 size 메소드를 통해 순회 가능
    * */
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
           if (x == ')') {
               while (stack.pop() != '(');
           } else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) answer += stack.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Practice0502 T = new Practice0502();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
