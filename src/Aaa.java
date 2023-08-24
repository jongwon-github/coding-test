public class Aaa {
    public static void main(String[] args) {
        Aaa a = new Aaa();
        String test = a.test("test", "test");
        System.out.println(test);
    }

    private <K, T> String test(K k, T t) {
        String args = "";
        if (k instanceof String) {
            System.out.println("스트링");
        }
        return args;
    }

}
