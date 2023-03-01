public class PreviousItemCommand extends Command {
    public PreviousItemCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.previousRecord();
        employeeDetails.displayRecords(employeeDetails.currentEmployee);
    }
}

