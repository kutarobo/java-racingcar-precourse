package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("입력받은 차량이름이 5글자를 넘을경우 exception 호출")
	void createCarFailCaseTest() {
		String carName = "메르세데스벤츠";
		IllegalArgumentException iae1 = assertThrows(IllegalArgumentException.class, () -> new Car(carName));
		assertThat(iae1.getMessage()).isEqualTo(CarName.GREATER_THEN_MAX_LENGTH_TEXT);
	}

	@Test
	@DisplayName("입력 받은 차량이름이 5글자 이내일경우 차량 객체 생성")
	void createCarSuccessCaseTest() {
		Car car1 = new Car("기아자동차");
		Car car2 = new Car("테슬라");

		assertThat(car1.getName().length())
			.isNotZero()
			.isLessThanOrEqualTo(CarName.MAX_LENGTH)
			.isEqualTo(5);

		assertThat(car2.getName().length())
			.isNotZero()
			.isLessThanOrEqualTo(CarName.MAX_LENGTH)
			.isEqualTo(3);
	}
}
