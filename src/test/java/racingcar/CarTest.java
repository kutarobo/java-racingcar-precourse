package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("입력받은 차량이름이 5글자를 넘을경우 exception 호출")
	void createCarFailCase() {
		// given
		String carName = "가나다라마바사";

		//when
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Car(carName));

		// then
		assertThat(iae.getMessage()).isEqualTo(CarName.GREATER_THEN_MAX_LENGTH_TEXT);
	}

	@Test
	@DisplayName("입력 받은 차량이름이 5글자 이내일경우 차량 객체 생성")
	void createCarSuccessCase() {
		// given
		String carName1 = "가나다라마";
		String carName2 = "가나다라";

		// when
		Car car1 = new Car(carName1);
		Car car2 = new Car(carName2);

		// then
		assertThat(car1.getName().getLength())
			.isNotZero()
			.isLessThanOrEqualTo(CarName.MAX_LENGTH)
			.isEqualTo(5);

		assertThat(car2.getName().getLength())
			.isNotZero()
			.isLessThanOrEqualTo(CarName.MAX_LENGTH)
			.isEqualTo(4);
	}
}
