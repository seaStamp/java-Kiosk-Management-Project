package input;

import exception.BadinputException;

import java.util.regex.Pattern;

public class Parser {
    // 정수에대해 파싱하는메서드
    private static final String NUMBER_REG = "^[0-9]*$";
    public int parseInt(String answer, int endInclusive) throws BadinputException {
        int number;
        /* 들어온 값이 정수로된 숫자인지 확인 */
        if (!Pattern.matches(NUMBER_REG, answer)) {
            throw new BadinputException(endInclusive);
        }
        number = Integer.parseInt(answer);
        /* 범위 확인 */
        if (number < 0 || number > endInclusive){
            throw new BadinputException(endInclusive);
        }
        return number;
    }
    // 실수에 대해 파싱하는 메서드
}
