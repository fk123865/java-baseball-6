package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidation validation = new InputValidation();

    public String readNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        validation.readNumberValidation(input);
        return input;
    }

    public int readRetry() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validation.readRetryValidation(input);
        return Integer.parseInt(input);
    }
}
