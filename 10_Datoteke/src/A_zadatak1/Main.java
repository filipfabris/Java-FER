package A_zadatak1;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		List<Employee> workers = EmployeeLoader.loadFromFile("data.txt");

		for (Employee e : workers) {
			System.out.println(e);
		}
	}

}
