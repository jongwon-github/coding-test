public class CdTest0705V1 {
    Node root;

    // 전위순회
    public void DFS1(Node node) {
        if (node == null) return;
        else {
            System.out.print(node.data + " ");
            DFS1(node.lt);
            DFS1(node.rt);
        }
    }

    // 중위순회
    public void DFS2(Node node) {
        if (node == null) return;
        else {
            DFS2(node.lt);
            System.out.print(node.data + " ");
            DFS2(node.rt);
        }
    }

    // 후위순회
    public void DFS3(Node node) {

    }

    public static void main(String[] args) {
        CdTest0705V1 tree = new CdTest0705V1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS1(tree.root);
        System.out.println();
        tree.DFS2(tree.root);
    }
}
