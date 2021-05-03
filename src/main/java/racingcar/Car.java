package racingcar;

import java.util.Collections;

public class Car {
	private static final int DEFAULT_DRIVE_DISTANCE = 0;
	private static final int MINIMUM_ADVANCE_NUMBER = 4;

	private CarName name;
	private int driveDistance = DEFAULT_DRIVE_DISTANCE;

	public Car(String name) {
		this.name = new CarName(name);
	}

	public void tryDrive(int tryNumber) {
		if (tryNumber < MINIMUM_ADVANCE_NUMBER) {
			return;
		}
		increaseDriveDistance();
	}

	private void increaseDriveDistance() {
		this.driveDistance++;
	}

	public String getName() {
		return name.getName();
	}

	public void setName(CarName name) {
		this.name = name;
	}

	public int getDriveDistance() {
		return driveDistance;
	}

	public void setDriveDistance(int driveDistance) {
		this.driveDistance = driveDistance;
	}

	public String getDisplayDistance() {
		return String.join("", Collections.nCopies(this.driveDistance, "-"));
	}
}
