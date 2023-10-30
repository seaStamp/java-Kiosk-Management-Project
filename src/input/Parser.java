package input;

import exception.BadinputException;

import java.util.regex.Pattern;

public class Parser {
    // 정수에대해 파싱하는메서드
    private static final String NUMBER_REG = "^[0-9]*$";
    public int parseInt(String answer, int startInclusive, int endInclusive) throws BadinputException {
        int number;
        /* 들어온 값이 빈 문자열인지 확인 */
        if (answer == null || answer.isEmpty()){
            throw new BadinputException(startInclusive, endInclusive);
        }
        /* 들어온 값이 정수로된 숫자인지 확인 */
        if (!Pattern.matches(NUMBER_REG, answer)) {
            throw new BadinputException(startInclusive, endInclusive);
        }
        number = Integer.parseInt(answer);

        /* 범위 확인 */
        if (number < startInclusive || number > endInclusive){
            throw new BadinputException(startInclusive, endInclusive);
        }

        return number;
    }
}
