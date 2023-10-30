package input;

import exception.OutOfRangeException;

import java.util.Scanner;

public class InputDevice {
    private static Scanner scanner;

    // 정수형 입력을 받는 메서드 (n은 1~n까지의 범위), -1을 반환하면 입력에 실패한것
    public static int receiveInt(int startInclusive, int endInclusive) {
        scanner = new Scanner(System.in);
        Parser parser = new Parser();
        int answer = -1;
        try {
            answer = parser.parseInt(scanner.nextLine(), startInclusive, endInclusive);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }

    // 실수형 입력을 받고 반환하는 메서드(상품생성 화면에서 쓰임, -1을 반환하면 입력에 실패한것)
    public static double receiveDouble() {
        Scanner scanner = new Scanner(System.in);
        double answer = -1;
        try {
            answer = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("<!> 잘못된 입력입니다! 실수 값을 입력해주세요!");
        }
        return answer;
    }

    // 오버로딩 (글자수 제한이 있는 것과 없는것)
    public static String receiveString() {
        scanner = new Scanner(System.in);
        String answer;

        answer = scanner.nextLine();
        while (answer.isEmpty()) {
            System.out.println("입력된 값이 없습니다. 다시 입력 부탁드립니다.");
            answer = scanner.nextLine();
        }
        return answer;
    }

    // 사용시 try-catch문으로 잡아줘야함.
    // 아무 값도 입력하지 않았을 경우 "(없음)"이 반환
    // 입력에 실패하면 ""값 반환
    public static String receiveString(int endInclusive) throws Exception {
        scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.length() > endInclusive) {
            throw new OutOfRangeException(endInclusive);
        }
        if (answer.isEmpty()) {
            answer = "(없음)";
        }
        return answer;
    }
}