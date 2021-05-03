package racingcar;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		if (car1.getDriveDistance() > car2.getDriveDistance()) {
			return 1;
		}
		if (car1.getDriveDistance() < car2.getDriveDistance()) {
			return -1;
		}
		return 0;
	}

	@Override
	public Comparator<Car> reversed() {
		return Comparator.super.reversed();
	}
}
