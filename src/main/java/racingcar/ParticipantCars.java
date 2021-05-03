package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ParticipantCars {

	public static final String EMPTY_INPUT_DATA_MESSAGE = "차량이름이 입력되지않았습니다. 차량이름을 입력해주세요";

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
}
