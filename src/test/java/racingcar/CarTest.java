package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("입력받은_차량이름이_다섯글자를_초과할경우_예외호출")
	void 입력받은_차량이름이_다섯글자를_초과할경우_예외호출() {
		String carName = "메르세데스벤츠";
		IllegalArgumentException iae1 = assertThrows(IllegalArgumentException.class, () -> new Car(carName));
		assertThat(iae1.getMessage()).isEqualTo(CarName.GREATER_THEN_MAX_LENGTH_TEXT);
	}

	@Test
	@DisplayName("입력받은_차량이름이_다섯글자_이내일경우_차량객체_생성")
	void 입력받은_차량이름이_다섯글자_이내일경우_차량객체_생성() {
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

	@Test
	@DisplayName("전진시도시_넘겨받은_숫자기준으로_전진하는지_검증")
	void 전진시도시_넘겨받은_숫자기준으로_전진하는지_검증() {
		Car car = new Car("아반떼");

		assertThat(car.getDriveDistance()).isEqualTo(0);
		car.tryDrive(0);
		assertThat(car.getDriveDistance()).isEqualTo(0);
		car.tryDrive(3);
		assertThat(car.getDriveDistance()).isEqualTo(0);
		car.tryDrive(4);
		assertThat(car.getDriveDistance()).isEqualTo(1);
		car.tryDrive(9);
		assertThat(car.getDriveDistance()).isEqualTo(2);
		assertThat(car.getDisplayDistance()).isEqualTo("--");
	}
}
