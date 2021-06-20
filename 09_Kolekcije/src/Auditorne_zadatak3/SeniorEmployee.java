package Auditorne_zadatak3;

import java.util.function.Predicate;

public class SeniorEmployee implements Predicate<Employee> {

	@Override
	public boolean test(Employee e) {
		return e.getSalary() >= 80000;
	}

}
