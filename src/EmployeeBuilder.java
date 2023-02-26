public class EmployeeBuilder {
    private int id;
    private String pps;
    private String surname;
    private String firstName;
    private char gender;
    private String department;
    private double salary;
    private boolean fullTime;

    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setPps(String pps) {
        this.pps = pps;
        return this;
    }

    public EmployeeBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setGender(char gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeBuilder setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
        return this;
    }

    public Employee build() throws IllegalStateException {
        if (id <= 0) {
            throw new IllegalStateException("Employee ID must be a positive integer");
        }

        if (pps == null || pps.isEmpty()) {
            throw new IllegalStateException("PPS number must not be empty");
        }

        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Surname must not be empty");
        }

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalStateException("First name must not be empty");
        }

        if (gender != 'M' && gender != 'F') {
            throw new IllegalStateException("Gender must be 'M' or 'F'");
        }

        if (department == null || department.isEmpty()) {
            throw new IllegalStateException("Department must not be empty");
        }

        if (salary <= 0) {
            throw new IllegalStateException("Salary must be a positive number");
        }

        return new Employee(id, pps, surname, firstName, gender, department, salary, fullTime);
    }
}