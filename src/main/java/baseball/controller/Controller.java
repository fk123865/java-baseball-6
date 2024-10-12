package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

// 전체적인 게임진행을 맡는 객체
public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BaseballGame game = new BaseballGame();

    public void run() {
        // 게임 시작
        outputView.printStart();
        do {
            // 게임 세팅
            game.init();

            playGame();

            outputView.printClear();
        } while (game.isRestart(inputView.readRetry())); // 사용자의 재시작 여부를 확인
    }

    private void playGame() {
        while (game.isNotGameClear()){
            game.game(inputView.readNumber());
            outputView.printResult(game.getResult());
        }
    }
}
