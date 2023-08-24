import java.util.LinkedList;
import java.util.Queue;

public class CdTest0707V1 {
    Node root;

    public void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        while (!Q.isEmpty()) {
            Node n = Q.poll();
            System.out.print(n.data + " ");
            if (n.lt != null) Q.offer(n.lt);
            if (n.rt != null) Q.offer(n.rt);
        }
    }

    public static void main(String[] args) {
        CdTest0707V1 tree = new CdTest0707V1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
