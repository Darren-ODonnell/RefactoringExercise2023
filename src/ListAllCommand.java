public class ListAllCommand extends Command {
    public ListAllCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            if (employeeDetails.isSomeoneToDisplay())
                employeeDetails.displayRecords(employeeDetails.currentEmployee);
    }
}

