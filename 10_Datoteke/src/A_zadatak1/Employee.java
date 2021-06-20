package A_zadatak1;

import java.time.LocalDate;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDate;

	public Employee(String name, double salary, LocalDate hireDate) {
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}

	public void raiseSalary(double byPercent) {
		salary = salary * (byPercent / 100.0 + 1);
	}

}
