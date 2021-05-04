package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantCarsTest {

	@Test
	@DisplayName("입력받은_문자를_기준으로_참여차량_목록을_생성")
	void 입력받은_문자를_기준으로_참여차량_목록을_생성() {
		ParticipantCars cars = new ParticipantCars("기아차,현대차,테슬라차");

		List<Car> participantCars = cars.getParticipantCars();

		assertThat(participantCars.get(0).getName()).isEqualTo("기아차");
		assertThat(participantCars.get(1).getName()).isEqualTo("현대차");
		assertThat(participantCars.get(2).getName()).isEqualTo("테슬라차");
	}

	@Test
	@DisplayName("참여차량_생성시_이름이_다섯글자초과_할_경우_예외처리")
	void 참여차량_생성시_이름이_다섯글자초과_할_경우_예외처리() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
			() -> new ParticipantCars("이름이 긴자동차, 기아차, 현대차"));

		assertThat(iae.getMessage()).isEqualTo(CarName.GREATER_THEN_MAX_LENGTH_TEXT);
	}

	@Test
	@DisplayName("우승자이름_출력")
	void 우승자이름_출력() {
		ParticipantCars cars = new ParticipantCars("기아차,현대차,테슬라차");
		List<Car> participantCars = cars.getParticipantCars();

		participantCars.get(0).tryDrive(4);
		assertThat(cars.getWinnerCarNames()).isEqualTo("기아차");
		participantCars.get(1).tryDrive(4);
		participantCars.get(1).tryDrive(4);
		assertThat(cars.getWinnerCarNames()).isEqualTo("현대차");
	}
}
