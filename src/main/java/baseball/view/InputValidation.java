package baseball.view;

//사용자의 입력을 검사하는 객체
public class InputValidation {

    // 사용자의 숫자를 검사
    public void readNumberValidation(String input) {
        if (isNotNumber(input) || input.length() != 3 || isInputZero(input)) {
            throw new IllegalArgumentException("세자리의 숫자만 입력 가능합니다.");
        }
    }

    // 사용자의 재시작 여부를 검사
    public void readRetryValidation(String input) {
        int restartNumber = Integer.parseInt(input);
        if (isNotNumber(input) || isNot1or2(restartNumber)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    private static boolean isNot1or2(int restartNumber) {
        return !(restartNumber == 1 || restartNumber == 2);
    }

    private boolean isNotNumber(String input) {
        return input.matches("[\\D+]]");
    }

    private boolean isInputZero(String input) {
        String[] inputNumbers = input.split("");
        for (String number : inputNumbers) {
            if (Integer.parseInt(number) < 1) {
                return true;
            }
        }
        return false;
    }
}
