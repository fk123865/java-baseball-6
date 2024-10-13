package baseball.domain;

import baseball.messgae.Message;

import java.util.List;

public class ResultMaker {

    private static final int STRIKE = 3;
    private static final int PAUL = 3;

    private static int strikeCount;
    private static int ballCount;
    private static int paulCount;

    public static String getResult(String input, List<Integer> computer) {
        countReset();
        count(input, computer);
        if (strikeCount == STRIKE){
            return Message.THREE_STRIKE.getMessage();
        }
        if (paulCount == PAUL){
            return Message.NOTHING.getMessage();
        }
        return ballCount + Message.BALL.getMessage() + strikeCount + Message.STRIKE.getMessage();
    }

    private static void count(String input, List<Integer> computer) {
        String[] inputNumbers = input.split("");
        for (int i = 0; i < inputNumbers.length; i++) {
            int number = Integer.parseInt(inputNumbers[i]);
            if (isStrike(number, computer, i)){
                strikeCount++;
            }
            if (isBall(number, computer, i)) {
                ballCount++;
            }
            if (isPaul(number, computer)){
                paulCount++;
            }
        }
    }

    private static boolean isStrike(int number, List<Integer> computer, int i) {
        return computer.contains(number) && computer.get(i) == number;
    }

    private static boolean isBall(int number, List<Integer> computer, int i) {
        return computer.contains(number) && computer.get(i) != number;
    }

    private static boolean isPaul(int number, List<Integer> computer) {
        return !computer.contains(number);
    }


    private static void countReset() {
        strikeCount = 0;
        ballCount = 0;
        paulCount = 0;
    }


}
