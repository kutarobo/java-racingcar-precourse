package racingcar;

public class Car {
	private static final int DEFAULT_DRIVE_DISTANCE = 0;

	private CarName name;
	private int driveDistance = DEFAULT_DRIVE_DISTANCE;

	public Car(String name) {
		this.name = new CarName(name);
	}

	public void increaseDriveDistance() {
		this.driveDistance++;
	}

	public void tryDrive() {
		if ((int)(Math.random() * 10) < 4) {
			return;
		}
		increaseDriveDistance();
	}

	public CarName getName() {
		return name;
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
}
