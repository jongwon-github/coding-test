public class Practice0701 {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n - 1);
            System.out.println(n + " ");
        }
    }

    public static void main(String[] args) {
        Practice0701 T = new Practice0701();
        T.DFS(3);
    }
}
