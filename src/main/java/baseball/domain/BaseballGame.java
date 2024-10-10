package baseball.domain;

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
        result = "";
        int ballCount = ballCount(input);
        int strikeCount = strikeCount(input);
        int paulCount = paulCount(input);

        if (ballCount != 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            result += strikeCount + "스트라이크 ";
        }
        if (paulCount == 3) {
            result = "낫싱";
        }
        if (strikeCount == 3) {
            gameClear = false;
        }
    }

    private int ballCount(String input){
        int count = 0;
        String[] inputNumbers = input.split("");
        for (int i = 0; i < inputNumbers.length; i++) {
            int inputNumber = Integer.parseInt(inputNumbers[i]);
            if (computer.contains(inputNumber) && !computer.get(i).equals(inputNumber)) {
                count ++;
            }
        }
        return count;
    }

    private int strikeCount(String input){
        int count = 0;
        String[] inputNumbers = input.split("");
        for (int i = 0; i < inputNumbers.length; i++) {
            int inputNumber = Integer.parseInt(inputNumbers[i]);
            if (computer.contains(inputNumber) && computer.get(i).equals(inputNumber)) {
                count ++;
            }
        }
        return count;
    }

    private int paulCount(String input){
        int count = 0;
        String[] inputNumbers = input.split("");
        for (int i = 0; i < inputNumbers.length; i++) {
            int inputNumber = Integer.parseInt(inputNumbers[i]);
            if (!computer.contains(inputNumber)) {
                count ++;
            }
        }
        return count;
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
