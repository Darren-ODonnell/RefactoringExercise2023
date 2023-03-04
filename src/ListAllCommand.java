public class ListAllCommand extends Command {
    public ListAllCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            displayEmployeeSummaryDialog();
    }

    // display Employee summary dialog
    private void displayEmployeeSummaryDialog() {
        // display Employee summary dialog if these is someone to display
        if (employeeDetails.isSomeoneToDisplay())
            new EmployeeSummaryDialog(employeeDetails.getAllEmployees());
    }// end displaySummaryDialog

}

