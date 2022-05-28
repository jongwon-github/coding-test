import java.util.Scanner;
import java.util.Stack;

public class Practice0504 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            /* char는 숫자를 0 -> 48, 1 -> 49 ... 으로 인식하기 때문에 아래와 같이 48을 빼줌으로써 실제 숫자값으로 인식되게 함 */
            if (Character.isDigit(x)) stack.push(x - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') stack.push(rt + lt);
                else if (x == '-') stack.push(rt - lt);
                else if (x == '*') stack.push(lt * rt);
                else if (x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Practice0504 T = new Practice0504();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
