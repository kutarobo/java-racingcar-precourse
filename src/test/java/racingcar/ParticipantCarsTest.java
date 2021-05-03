package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantCarsTest {

	@Test
	@DisplayName("입력받은 문자를 컴마 기준으로 스플릿해서 참가차량 목록으로 만들기 성공케이스")
	void getParticipantCarsSuccessCaseTest() throws Exception {
		ParticipantCars cars = new ParticipantCars("기아차,현대차,테슬라차");

		List<Car> participantCars = cars.getParticipantCars();

		assertThat(participantCars.get(0).getName()).isEqualTo("기아차");
		assertThat(participantCars.get(1).getName()).isEqualTo("현대차");
		assertThat(participantCars.get(2).getName()).isEqualTo("테슬라차");
	}

	@Test
	@DisplayName("입력받은 문자를 컴마 기준으로 스플릿해서 참가차량 목록으로 만들기 실패케이스")
	void getParticipantCarsFailCaseTest() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
			() -> new ParticipantCars("이름이 긴자동차, 기아차, 현대차"));

		assertThat(iae.getMessage()).isEqualTo(CarName.GREATER_THEN_MAX_LENGTH_TEXT);
	}
}
