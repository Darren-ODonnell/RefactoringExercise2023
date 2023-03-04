public class SearchBySurnameDialogCommand extends Command {
    public SearchBySurnameDialogCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            displaySearchBySurnameDialog();

    }

    // display search by surname dialog
    private void displaySearchBySurnameDialog() {
        if (employeeDetails.isSomeoneToDisplay())
            new SearchBySurnameDialog(employeeDetails);
    }// end displaySearchBySurnameDialog



}
