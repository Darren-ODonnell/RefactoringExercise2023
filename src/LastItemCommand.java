public class LastItemCommand extends Command {
    public LastItemCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.lastRecord();
        employeeDetails.displayRecords(employeeDetails.currentEmployee);
    }
}

