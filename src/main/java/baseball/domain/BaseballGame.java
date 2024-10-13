package baseball.domain;

import baseball.messgae.Message;

import java.util.List;

public class BaseballGame {

    private List<Integer> computer;

    private boolean gameClear = true;

    private String result;

    // 컴퓨터의 숫자를 셋팅
    public void init() {
        computer = BaseballMaker.computer();
    }

    // 사용자의 입력과 컴퓨터의 숫자를 비교해 결과를 만듬
    public void game(String input) {
        result = ResultMaker.getResult(input, computer);
        if (resultIsThreeStrike()) {
            gameClear = false;
        }
    }

    private boolean resultIsThreeStrike() {
        return result.equals(Message.THREE_STRIKE.getMessage());
    }

    public boolean isNotGameClear() {
        return gameClear;
    }

    public String getResult() {
        return result;
    }

    public boolean isRestart(int input) {
        if (input == 1) {
            computer.clear();
            gameClear = true;
            return true;
        }
        return false;
    }
}
