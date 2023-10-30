package exception;

public class BadinputException extends Exception {
    public BadinputException(int startnum, int endnum) {
        super("<!> 잘못된 입력입니다! " + startnum + "~" + endnum + "사이의 값을 입력해주세요!");
    }
}
