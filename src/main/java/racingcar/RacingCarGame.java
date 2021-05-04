package racingcar;

import java.util.Scanner;

public class RacingCarGame {
	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String RESULT_MESSAGE = "실행 결과";

	private int tryCount;
	private InputUtils inputUtils;
	private ParticipantCars participantCars;

	public RacingCarGame() {
		this.tryCount = 0;
		this.inputUtils = new InputUtils(new Scanner(System.in));
	}

	public void run() {
		try {
			participantCars = new ParticipantCars(getInputData(INPUT_CAR_NAME_MESSAGE));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			run();
			return;
		}
		inputTryCount();
		race();
		endGame();
	}

	private void race() {
		System.out.println(RESULT_MESSAGE);
		for (int i = 0; i < this.tryCount; i++) {
			participantCars.race();
		}
	}

	private String getInputData(String outputMessage) {
		System.out.println(outputMessage);
		return inputUtils.getInputData();
	}

	private void inputTryCount() {
		String tryCount = getInputData(INPUT_TRY_COUNT_MESSAGE);
		if (!tryCount.chars().allMatch(Character::isDigit) && Integer.parseInt(tryCount) > 0) {
			inputTryCount();
			return;
		}
		this.tryCount = Integer.parseInt(tryCount);
	}

	private void endGame() {
		System.out.println(participantCars.getWinnerCarNames() + "가 최종 우승 했습니다.");
	}
}
