package racingcar;

import java.util.Scanner;

public class InputUtils {
	public Scanner scanner;

	public InputUtils(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInputData() {
		return scanner.nextLine();
	}
}
