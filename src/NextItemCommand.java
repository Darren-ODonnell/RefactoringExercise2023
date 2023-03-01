public class NextItemCommand extends Command {
    public NextItemCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.nextRecord();
        employeeDetails.displayRecords(employeeDetails.currentEmployee);
    }
}

