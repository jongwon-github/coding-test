public class Practice0704 {
    public int DFS(int n) {
        if (n == 1 || n == 2) return 1;
        else return DFS(n - 1) + DFS(n - 2);
    }

    public static void main(String[] args) {
        Practice0704 T = new Practice0704();
        int n = 5;
        System.out.println(T.DFS(n));
    }
}