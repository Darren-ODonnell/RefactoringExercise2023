public class SearchSurnameCommand extends Command {
    public SearchSurnameCommand(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    public void execute() {
        if (employeeDetails.checkInput() && !employeeDetails.checkForChanges())
            employeeDetails.searchEmployeeBySurname();
    }
}
