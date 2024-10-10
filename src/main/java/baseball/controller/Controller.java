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
            game.init();

            // 사용자가 숫자를 맞힐 때까지 반복
            while (game.isNotGameClear()){
                game.game(inputView.readNumber());
                outputView.printResult(game.getResult());
            }
            // while문이 끝나면 성공한 것으로 Clear를 출력
            outputView.printClear();
        } while (game.isRestart(inputView.readRetry())); // 사용자의 재시작 여부를 확인
    }
}
