public abstract class Command {
    protected  EmployeeDetails employeeDetails;
    public Command(EmployeeDetails employeeDetails){
        this.employeeDetails = employeeDetails;
    }
    abstract void execute();
}
