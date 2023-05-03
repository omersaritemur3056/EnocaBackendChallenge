public class App {
    public static void main(String[] args) throws Exception {

        example2();
    }

    public static void example1() {
        for (int i = 0; i <= 10; i++) {
            if (i == 0) {
                System.out.println("*");
            } else if (i % 2 == 0) {
                System.out.println("*".repeat(i));
            } else {
                System.out.println(" ");
            }
        }
    }

    public static void example2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            boolean isEven = i % 2 == 0;
            if (i == 0) {
                System.out.println("*");
            } else if (isEven) {
                sb.setLength(0);
                for (int j = 0; j < i; j++) {
                    sb.append("*");
                }
                System.out.println(sb.toString());
            } else {
                System.out.println(" ");
            }
        }
    }
}
