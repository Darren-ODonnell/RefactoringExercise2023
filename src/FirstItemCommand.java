public class FirstItemCommand extends Command {
    public FirstItemCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.firstRecord();
        employeeDetails.displayRecords(employeeDetails.currentEmployee);
    }
}

