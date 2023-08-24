import java.util.LinkedList;
import java.util.Queue;

public class CdTest0710V1 {
    Node root;

    public int BFS(Node node) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n.lt == null && n.rt == null) break;
                queue.offer(n.lt);
                queue.offer(n.rt);
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0710V1 T = new CdTest0710V1();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));
    }
}
