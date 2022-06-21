public class Practice0703 {
    public int DFS(int n) {
        if (n == 0) return 1;
        else return n * DFS(n - 1);
    }

    public static void main(String[] args) {
        Practice0703 T = new Practice0703();
        System.out.println(T.DFS(5));
    }
}
