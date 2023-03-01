public class SearchBySurnameDialogCommand extends Command {
    public SearchBySurnameDialogCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.displaySearchBySurnameDialog();

    }
}
