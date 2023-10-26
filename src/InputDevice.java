import java.util.Scanner;

public class InputDevice {
    private static Scanner scanner;
    private static Parser parser;

    // 정수형 입력을 받는 메서드 (n은 1~n까지의 범위), -1을 반환하면 입력에 실패한것
    public static int receiveInput(int n) {
        scanner = new Scanner(System.in);
        parser = new Parser();
        int answer = -1;
        try {
            parser.parseInt(scanner.nextLine(), n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }

    // 실수형 입력을 받고 반환하는 메서드(상품생성 화면에서
    public double receiveInputDouble() {
        Scanner scanner = new Scanner(System.in);
        double answer = 0;
        return answer;
    }

    // 오버로딩 (글자수 제한이 있는 것과 없는것)
    public static String receiveInputString() {
        String answer = null;
        return answer;
    }

    public static String receiveInputString(int n) {
        String answer = null;
        return answer;
    }
}