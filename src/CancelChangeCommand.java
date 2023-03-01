public class CancelChangeCommand extends Command {
    public CancelChangeCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.cancelChange();
    }
}

