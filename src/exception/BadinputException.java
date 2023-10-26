package exception;

public class BadinputException extends Exception{
    public BadinputException(int num) {
        super("<!> 잘못된 입력입니다! 1~" + num + "사이의 값을 입력해주세요!");
    }
}
