package Auditorne_zadatak3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {

	public static List<Employee> loadFromFile(String fileName) throws IOException {
		List<Employee> list = new ArrayList<>();
		FileReader fr = new FileReader(fileName, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		while (line != null) {
			list.add(readEmployee(line));
			line = br.readLine();
		}

		return list;

	}

	private static Employee readEmployee(String line) throws IOException {
		String[] splits = line.split(";");

		if (splits.length < 5) {
			throw new IOException("Greska kod citanja");
		}

		String name;
		double salary;
		int year;
		int month;
		int day;
		try {
			name = splits[0];
			salary = Double.parseDouble(splits[1]);
			year = Integer.parseInt(splits[2]);
			month = Integer.parseInt(splits[3]);
			day = Integer.parseInt(splits[4]);
		} catch (NumberFormatException e) {
			throw new IOException("Problem kod parsiranja");
		}

		return new Employee(name, salary, LocalDate.of(year, month, day));
	}

}
