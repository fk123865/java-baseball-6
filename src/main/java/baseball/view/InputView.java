package baseball.view;

import baseball.messgae.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidation validation = new InputValidation();

    public String readNumber() {
        System.out.print(Message.USER_INPUT);
        String input = Console.readLine();
        validation.readNumberValidation(input);
        return input;
    }

    public int readRetry() {
        System.out.println(Message.GAME_RESTART);
        String input = Console.readLine();
        validation.readRetryValidation(input);
        return Integer.parseInt(input);
    }
}
