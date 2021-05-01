package racingcar;

public class CarName {
	public static final int MAX_LENGTH = 5;
	public static final String GREATER_THEN_MAX_LENGTH_TEXT = "차량이름은 5자 이하이어야 합니다";

	private String name;

	public CarName(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(GREATER_THEN_MAX_LENGTH_TEXT);
		}
		this.name = name;
	}

	public int getLength() {
		return this.name.length();
	}
}
