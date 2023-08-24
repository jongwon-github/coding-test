import java.util.Scanner;

public class CdTest0709V1 {
    Node root;
    int answer = Integer.MAX_VALUE;

    public int DFS(int L, Node node) {
//        if (node.lt == null && node.rt == null) answer = Math.min(answer, L);
//        else {
//            DFS(L + 1, node.lt);
//            DFS(L + 1, node.rt);
//        }
//        return answer;
        if (node.lt == null && node.rt == null) return L;
        else return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
    }

    public static void main(String[] args) {
        CdTest0709V1 T = new CdTest0709V1();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.DFS(0, T.root));
    }
}
