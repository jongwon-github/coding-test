import java.util.Scanner;
import java.util.Stack;

public class Practice0504 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            int lt = 0;
            int rt = 0;
            if (!stack.isEmpty()) {
                System.out.println("여기를 들어오나요?");
                lt = stack.pop();
                rt = stack.pop();
            }
            switch (ch) {
                case '+':
                    stack.push(lt + rt);
                    break;
                case '-':
                    stack.push(lt - rt);
                    break;
                case '*':
                    stack.push(lt * rt);
                    break;
                case '/':
                    stack.push(lt / rt);
                    break;
                default:
                    stack.push(Character.getNumericValue(ch));
                    break;
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
