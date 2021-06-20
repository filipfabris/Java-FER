package Auditorne_zadatak3;

import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) throws IOException {

		List<Employee> workers = EmployeeLoader.loadFromFile("data.txt");

		for (Employee e : workers) {
			System.out.println(e);
		}

		System.out.println("*** Juniors ****");
		printEmployees(workers, new JuniorEmployee());
		System.out.println();

		System.out.println("*** Seniors ****");
		printEmployees(workers, new SeniorEmployee());
		System.out.println();

		for (Employee e : workers) {
			e.raiseSalary(15);
		}

		System.out.println("*** New Juniors ****");
		// anonimna klasa
		printEmployees(workers, new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				return e.getSalary() < 80000;
			}
		});

		System.out.println();

		System.out.println("*** New Seniors ****");
		// lamda izraz
		printEmployees(workers, e -> e.getSalary() >= 80000);

		System.out.println();

		theMostSimilarEmployees(workers,
				(a, b) -> (int) Math.abs(a.getHireDate().toEpochDay() - b.getHireDate().toEpochDay()));

	}

	public static void theMostSimilarEmployees(Iterable<Employee> employees,
			BiFunction<Employee, Employee, Integer> similarityFunction) {
		Employee SimilarA = null;
		Employee SimilarB = null;
		int similarityValue = Integer.MAX_VALUE;

		for (Employee a : employees) {
			for (Employee b : employees) {
				if (a == b) {
					continue;
				}
				if (similarityFunction.apply(a, b) < similarityValue) {
					SimilarA = a;
					SimilarB = b;
					similarityValue = similarityFunction.apply(a, b);
				}

			}
		}
		System.out.printf("The similar employees are:\n\t %s \n\t %s", SimilarA, SimilarB);

	}

	public static void printEmployees(Iterable<Employee> employees, Predicate<Employee> condition) {
		for (Employee e : employees) {
			if (condition.test(e)) {
				System.out.println(e);
			}
		}
	}

}
