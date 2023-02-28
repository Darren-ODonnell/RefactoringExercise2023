/*
 * 
 * This is the definition of the Employee object
 * 
 * */

import java.util.Vector;

public class Employee{
	private int employeeId;
	private String pps;
	private String surname;
	private String firstName;
	private char gender;
	private String department;
	private double salary;
	private boolean fullTime;

	// Create Employee with no details
	public Employee() {
		this.employeeId = 0;
		this.pps = "";
		this.surname = "";
		this.firstName = "";
		this.gender = '\0';
		this.department = "";
		this.salary = 0;
		this.fullTime = false;
	}//end Employee with no details

	// Create Employee with details
	public Employee(int employeeId, String pps, String surname, String firstName, char gender, String department, double salary,
			boolean fullTime) {
		this.employeeId = employeeId;
		this.pps = pps;
		this.surname = surname;
		this.firstName = firstName;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.fullTime = fullTime;
	}// end Employee with details

	// Getter methods
	public int getEmployeeId() {
		return this.employeeId;
	}

	public String getPps() {
		return pps;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public char getGender() {
		return this.gender;
	}

	public String getDepartment() {
		return this.department;
	}

	public double getSalary() {
		return this.salary;
	}

	public boolean getFullTime() {
		return this.fullTime;
	}

	// Setter methods
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setPps(String pps) {
		this.pps = pps;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	// Display Employee details
	public String toString() {
		String bool = "";
		if (fullTime)
			bool = "Yes";
		else
			bool = "No";

		return "Employee ID: " + this.employeeId + "\nPPS Number: " + this.pps + "\nSurname: " + this.surname
				+ "\nFirst Name: " + this.firstName + "\nGender: " + this.gender + "\nDepartment: " + this.department + "\nSalary: " + this.salary
				+ "\nFull Time: " + bool;
	}// end toString
	public Vector<Object> toVector() {
		Vector<Object> v = new Vector<Object>();
		v.add(this.employeeId);
		v.add(this.pps);
		v.add(this.surname);
		v.add(this.firstName);
		v.add(this.gender);
		v.add(this.department);
		v.add(this.salary);
		v.add(this.fullTime);
		return v;
	}

	public static Employee fromVector(Vector<Object> v) {
		Employee e = new Employee();
		e.setEmployeeId((int) v.get(0));
		e.setPps((String) v.get(1));
		e.setSurname((String) v.get(2));
		e.setFirstName((String) v.get(3));
		e.setGender((Character) v.get(4));
		e.setDepartment((String) v.get(5));
		e.setSalary((double) v.get(6));
		e.setFullTime((boolean) v.get(7));
		return e;
	}
}// end class Employee
