package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantCars {
	private static final String EMPTY_INPUT_DATA_MESSAGE = "차량이름이 입력되지않았습니다. 차량이름을 입력해주세요";
	private static final int MAXIMUM_RANDOM_NUMBER = 9;

	private List<Car> participantCars;

	public ParticipantCars(String inputData) {
		if (!validInputData(inputData)) {
			throw new IllegalArgumentException(EMPTY_INPUT_DATA_MESSAGE);
		}
		this.participantCars = mapCars(inputData.split(","));
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
			car.tryDrive((int)(Math.random() * (MAXIMUM_RANDOM_NUMBER + 1)));
		}
		printRaceResult();
	}

	private void printRaceResult() {
		for (Car car : participantCars) {
			System.out.println(car.getName() + " : " + car.getDisplayDistance());
		}
		System.out.println();
	}

	private int getMaxDistance() {
		Collections.sort(this.participantCars, new CarComparator().reversed());
		return participantCars.get(0).getDriveDistance();
	}

	public String getWinnerCarNames() {
		int maxDistance = getMaxDistance();
		return participantCars.stream()
			.filter(car -> car.getDriveDistance() == maxDistance)
			.map(car -> car.getName())
			.collect(Collectors.joining(", "));
	}
}
