package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParticipantCars {

	public static final String EMPTY_INPUT_DATA_MESSAGE = "차량이름이 입력되지않았습니다. 차량이름을 입력해주세요";

	private List<Car> participantCars;
	private List<Car> winners;

	public ParticipantCars(String inputData) {
		if (!validInputData(inputData)) {
			throw new IllegalArgumentException(EMPTY_INPUT_DATA_MESSAGE);
		}
		this.participantCars = mapCars(inputData.split(","));
		this.winners = new ArrayList<>();
	}

	private boolean validInputData(String inputData) {
		if (inputData.length() < 1) {
			return false;
		}
		return true;
	}

	private static List<Car> mapCars(String[] inputData) {
		List<Car> participantCars = new ArrayList<>();
		for (int i = 0; i < inputData.length; i++) {
			participantCars.add(new Car(inputData[i].trim()));
		}
		return participantCars;
	}

	public List<Car> getParticipantCars() {
		return participantCars;
	}

	public void setParticipantCars(List<Car> participantCars) {
		this.participantCars = participantCars;
	}

	public void race() {
		for (Car car : participantCars) {
			car.tryDrive((int)(Math.random() * 10));
		}
		printRaceResult();
	}

	private void printRaceResult() {
		for (Car car : participantCars) {
			System.out.println(car.getName() + " : " + car.getDisplayDistance());
		}
		System.out.println();
	}

	public void setWinners() {
		int maxDistance = getMaxDistance();
		for (Car car : participantCars) {
			addWinner(car, maxDistance);
		}
	}

	private void addWinner(Car car, int maxDistance) {
		if (car.getDriveDistance() < maxDistance) {
			return;
		}
		winners.add(car);
	}

	private int getMaxDistance() {
		Collections.sort(this.participantCars, new CarComparator().reversed());
		return participantCars.get(0).getDriveDistance();
	}

	public List<Car> getWinners() {
		return winners;
	}

	public String getWinnerCarNames() {
		List<String> winnerCarNames = new ArrayList<>();
		for (Car car : winners) {
			winnerCarNames.add(car.getName());
		}
		return String.join(", ", winnerCarNames);
	}
}
