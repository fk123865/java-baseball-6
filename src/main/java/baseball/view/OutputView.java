package baseball.view;

import baseball.messgae.Message;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printClear() {
        System.out.println(Message.GAME_CLEAR);
    }

    public void printStart() {
        System.out.println(Message.GAME_START);
    }
}
