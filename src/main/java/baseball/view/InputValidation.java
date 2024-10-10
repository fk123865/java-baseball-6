package baseball.view;

//사용자의 입력을 검사하는 객체
public class InputValidation {

    // 사용자의 숫자를 검사
    public void readNumberValidation(String input) {
        if (isNotNumber(input) || input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (isInputZero(input)) {
            throw new IllegalArgumentException();
        }
    }

    // 사용자의 재시작 여부를 검사
    public void readRetryValidation(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
        int i = Integer.parseInt(input);
        if (!(i == 1 || i == 2)) {
            throw new IllegalArgumentException();
        }
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
