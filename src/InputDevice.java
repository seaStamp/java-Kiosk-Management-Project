import java.util.Scanner;

public class InputDevice {
    private static Scanner scanner;

    // 정수형 입력을 받는 메서드 (n은 1~n까지의 범위)
    public int receiveInput(int n) {
        Scanner scanner = new Scanner(System.in);
        int answer = 1;
        return answer;
    }

    // 실수형 입력을 받고 반환하는 메서드(상품생성 화면에서
    public double receiveInputDouble() {
        Scanner scanner = new Scanner(System.in);
        double answer = 0;
        return answer;
    }

    // 오버로딩 (글자수 제한이 있는 것과 없는것)
    public String receiveInputString() {
        String answer = null;
        return answer;
    }

    public String receiveInputString(int n){
        String answer = null;
        return answer;
    }
}