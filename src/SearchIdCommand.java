public class SearchIdCommand extends Command {
    public SearchIdCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            displaySearchByIdDialog();
    }

    void displaySearchByIdDialog() {
        if (employeeDetails.isSomeoneToDisplay())
            new SearchByIdDialog(employeeDetails);

    }// end displaySearchByIdDialog




}
