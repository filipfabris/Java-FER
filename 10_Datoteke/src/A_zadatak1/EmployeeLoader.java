package A_zadatak1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {
	public static List<Employee> loadFromFile(String fileName) {

		List<Employee> list = new ArrayList<>();

		try (FileReader fr = new FileReader(fileName, Charset.forName("UTF-8"));
				BufferedReader reader = new BufferedReader(fr)) {

			String line;
			while ((line = reader.readLine()) != null) {
				list.add(readEmployee(line));

			}

		} catch (IOException e) {
			System.err.println("Can not read data" + fileName);
			e.printStackTrace();
		}

		return list;

	}

	private static Employee readEmployee(String line) throws IOException {
		String[] splits = line.split(";");
		if (splits.length < 5) {
			throw new IOException("Can not read");
		}

		String name = splits[0];

		double salary;
		try {
			salary = Double.parseDouble(splits[1]);

		} catch (NumberFormatException e) {
			throw new IOException("Can not read salary in line: " + line, e);
		}

		int year;
		try {
			year = Integer.parseInt(splits[2]);

		} catch (NumberFormatException e) {
			throw new IOException("Can not read year in line: " + line, e);
		}

		int month;
		try {
			month = Integer.parseInt(splits[3]);

		} catch (NumberFormatException e) {
			throw new IOException("Can not read month in line: " + line, e);
		}

		int day;
		try {
			day = Integer.parseInt(splits[4]);

		} catch (NumberFormatException e) {
			throw new IOException("Can not read day in line: " + line, e);
		}

		try {
			return new Employee(name, salary, LocalDate.of(year, month, month));
		} catch (DateTimeException e) {
			throw new IOException("Can not create date with line: " + line, e);
		}

	}

}
