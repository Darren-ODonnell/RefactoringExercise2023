public class SearchByIdCommand extends Command {
    public SearchByIdCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.displaySearchIdDialog();
    }
}
