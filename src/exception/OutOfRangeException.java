package exception;

public class OutOfRangeException extends Exception{
    public OutOfRangeException(int endInclusive){
        super("<!> 입력 범위를 초과했습니다!" + endInclusive + "자 이내로 작성해주세요.");
    }
}
